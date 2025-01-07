package com.netflix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;

import picocli.CommandLine;

/**
 * CLI application to manage Netflix movies using picocli.
 * This CLI allows users to add movies, add reviews, list all movies,
 * and search for movies by various criteria such as name, year, category, or
 * director.
 */
@CommandLine.Command(name = "netflix-cli", mixinStandardHelpOptions = true, description = "Netflix CLI to manage movies", subcommands = {
        SearchCommand.class } // Register SearchCommand as a subcommand
)
public class CLI implements Callable<Integer> {

    /**
     * Option to display the help message for the CLI.
     */
    @CommandLine.Option(names = { "-h", "--help" }, usageHelp = true, description = "Display help message")
    boolean helpRequested;

    /**
     * Command to add a new movie.
     * This is a placeholder and should be extended with actual implementation.
     */
    @CommandLine.Command(name = "add", description = "Add a movie")
    void addMovie() {
        System.out.println("Adding a movie");
        String showId = String.valueOf(DBActions.generateMovieShowId());
        Movie movie = new Movie(showId, "Movie", "The Matrix", "Lana Wachowski", "Keanu Reeves, Laurence Fishburne",
                "United States", "August 1, 2021", 1999, "R", "2h 16m", "Action & Adventure, Sci-Fi",
                "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
                new ArrayList<>(Arrays.asList()));
        System.out.println(movie);
    }

    /**
     * Command to add a review to a movie.
     * This is a placeholder and should be extended with actual implementation.
     */
    @CommandLine.Command(name = "review", description = "Add a review")
    void addReview(
            @CommandLine.Option(names = { "-i", "--id" }, description = "Show ID of the movie to review") String showId,
            @CommandLine.Option(names = { "-c", "--comment" }, description = "Comment for the movie") String comment) {
        if (showId == null || comment == null) {
            System.out.println("Show ID and comment are required.");
            // Display usage
            return;
        }

        System.out.println("Adding a review...");

        DBActions.addReview(showId, comment);

        System.out.println("Review added successfully.");
        System.out.println("Show ID: " + showId);
        System.out.println("Comment: " + comment);

    }

    /*
     * Command to list all movies.
     * Users can specify limit and page number to display a subset of movies.
     * netflix-cli list --limit 5 --page 1
     * netflix-cli list --help (to display usage of list command)
     */
    @CommandLine.Command(name = "list", description = "List all movies", mixinStandardHelpOptions = true)
    void getMovieList(
            @CommandLine.Option(names = {
                    "--limit" }, description = "Number of movies per page", defaultValue = "5") int limit,
            @CommandLine.Option(names = {
                    "--page" }, description = "Page number to display", defaultValue = "1") int page) {
        if (limit <= 0 || page <= 0) {
            System.out.println("Limit and page must be greater than 0.");
            return;
        }

        int start = (page - 1) * limit;
        System.out.printf("Fetching movies from %d to %d%n", start + 1, start + limit);
        DBActions.listAll(limit, page);
    }

    /**
     * Default method that is executed if no valid subcommand is provided.
     * Displays a usage message.
     *
     * @return Exit code (1 indicates failure).
     * @throws Exception if an error occurs during execution.
     */
    @Override
    public Integer call() throws Exception {
        System.err.println("Use 'netflix-cli --help' for usage.");
        return 1;
    }

    /**
     * Main entry point for the Netflix CLI application.
     *
     * @param args Command-line arguments passed by the user.
     */
    public static void main(String[] args) {
        int exitCode = new CommandLine(new CLI()).execute(args);
        System.exit(exitCode);
    }
}

/**
 * SearchCommand class defines the functionality to search for movies.
 * Users can search by name, year, category, or director using command-line
 * options.
 */
@CommandLine.Command(name = "search", description = "Search movies by name, year, category, or director")
class SearchCommand implements Callable<Integer> {

    /**
     * Option to search movies by name.
     */
    // java -jar target\netflix-1.0-SNAPSHOT.jar search --name The Matrix
    @CommandLine.Option(names = { "-n", "--name" }, description = "Search movies by name")
    String name;

    /**
     * Option to search movies by year.
     */
    @CommandLine.Option(names = { "-y", "--year" }, description = "Search movies by year")
    String year;

    /**
     * Option to search movies by category.
     */
    @CommandLine.Option(names = { "-c", "--category" }, description = "Search movies by category")
    String category;

    /**
     * Option to search movies by director.
     */
    @CommandLine.Option(names = { "-d", "--director" }, description = "Search movies by director")
    String director;

    /**
     * Executes the search functionality based on the provided options.
     * Displays appropriate messages for the selected search criterion.
     *
     * @return Exit code (0 indicates success).
     */
    @Override
    public Integer call() {
        if (name != null) {
            System.out.println("Searching movies by name: " + name);
            DBActions.listbyName(name);
        } else if (year != null) {
            System.out.println("Searching movies by year: " + year);
            DBActions.listByReleaseDate(year);
        } else if (category != null) {
            System.out.println("Searching movies by category: " + category);
            DBActions.listByCategory(category);
        } else if (director != null) {
            System.out.println("Searching movies by director: " + director);
            DBActions.listByDirector(director);
        } else {
            System.out.println("Invalid search criteria or no search criteria provided.");
        }
        return 0;
    }
}