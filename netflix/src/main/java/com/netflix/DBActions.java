package com.netflix;

public class DBActions {
    public static void addMovie(Movie movie) {
        System.out.println("Adding movie to database: " + movie.getName());
    }

    public static void addReview(Movie movie) {
        System.out.println("Adding review to database: " + movie.getReview());
    }

    public static void listbyName(String name) {
        System.out.println("Listing movies by name: " + name);
    }

    public static void listByDirector(String director) {
        System.out.println("Listing movies by director: " + director);
    }

    public static void listByCategory(String category) {
        System.out.println("Listing movies by category: " + category);
    }

    public static void listByReleaseDate(String release_date) {
        System.out.println("Listing movies by release date: " + release_date);
    }

    public static void listAll() {
        System.out.println("Listing all movies");
    }

}
