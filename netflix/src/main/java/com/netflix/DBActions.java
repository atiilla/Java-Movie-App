package com.netflix;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class DBActions {
    private static final String FILE_PATH = "src/main/resources/netflix_titles.csv";
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

    // Method to read CSV file and return list of movies
    public static List<String[]> readCsv() {
        try (CSVReader reader = new CSVReader(new FileReader(FILE_PATH))) {
            return reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to get a movie or movies by name
    public static List<String[]> getMovieByName(String name) {
        List<String[]> movies = readCsv();
        if (movies == null) {
            return null;
        }
        return movies;
    }

}
