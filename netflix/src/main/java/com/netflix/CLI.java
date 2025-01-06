package com.netflix;
import java.util.concurrent.Callable;

import picocli.CommandLine;

/*
 @CommandLine.Command annotation is used to define the command name and description.
 */
@CommandLine.Command(name = "netflix-cli", mixinStandardHelpOptions = true, description = "Netflix CLI to manage movies")
public class CLI implements Callable<Integer> {
    
    /* 
        @CommandLine.Option annotation is used to define the command line options.
        The 'usageHelp' attribute is used to display the help message when the option is used.
    */
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Display help message")
    boolean helpRequested;


    /*
     * @CommandLine.Command annotation is used to define the subcommands.
    */
    @CommandLine.Command(name = "add", description = "Add a movie")
    void addMovie() {
        System.out.println("Adding a movie");
    }

    @CommandLine.Command(name = "review", description = "Add a review")
    void addReview() {
        System.out.println("Adding a review");
    }

    @CommandLine.Command(name = "director", description = "List movies by director")
    void getByDirector() {
        System.out.println("Listing movies by director");
    }

    @CommandLine.Command(name = "category", description = "List movies by category")
    void getByCategory() {
        System.out.println("Listing movies by category");
    }

    @CommandLine.Command(name = "year", description = "List movies by release year")
    void releaseYear() {
        System.out.println("Listing movies by release year");
    }

    // @CommandLine.Command(name = "name", description = "List movies by name")
    // void getByName(@CommandLine.Parameters(description = "Movie name") List name) {
    //     // Join the list of names into a single string
    //     String strMovie = String.join(" ", name);

    //     System.out.println("Listing movies by name: " + strMovie);
    //     DBActions.listbyName(strMovie);
    // }

    // Search Command for name or year or category or director. With Subcommands
    @CommandLine.Command(name = "search", description = "Search movies by name, year, category or director")
    void search() {
        SearchCommand searchCommand = new SearchCommand();
        CommandLine searchCommandLine = new CommandLine(searchCommand);
        searchCommandLine.execute();
    }


    

    @CommandLine.Command(name = "list", description = "List all movies")
    void getMovieList() {
        System.out.println("Listing all movies");
    }



    @Override
    public Integer call() throws Exception {
        System.err.println(" Use 'netflix-cli --help' for usage.");
        return 1;
    }
    
}


// Search Command for name or year or category or director. With Subcommands
class SearchCommand {
    @CommandLine.Option(names = {"-n", "--name"}, description = "Search movies by name")
    String name;

    @CommandLine.Option(names = {"-y", "--year"}, description = "Search movies by year")
    String year;

    @CommandLine.Option(names = {"-c", "--category"}, description = "Search movies by category")
    String category;

    @CommandLine.Option(names = {"-d", "--director"}, description = "Search movies by director")
    String director;

    @CommandLine.Command
    void search() {
        if (name != null) {
            System.out.println("Searching movies by name: " + name);
            
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
            System.out.println("Please provide a search criteria");
        }
    }
}