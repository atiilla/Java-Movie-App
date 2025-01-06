package com.netflix;
import java.util.concurrent.Callable;

import picocli.CommandLine;

@CommandLine.Command(name = "netflix-cli", mixinStandardHelpOptions = true, description = "Netflix CLI to manage movies")
public class CLI implements Callable<Integer> {
    
    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "Display help message")
    boolean helpRequested;


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

    @CommandLine.Command(name = "name", description = "List movies by name")
    void getByName() {
        System.out.println("Listing movies by name");
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