package com.netflix;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import picocli.CommandLine;

/*
  Main class for Netflix Movie CLI
*/
public class App {
    // CSV file path
    private static final String FILE_PATH = "src/main/resources/netflix_titles.csv";

    public static void main(String[] args) {
        // show_id,type,title,director,cast,country,date_added,release_year,rating,duration,listed_in,description

        List<String[]> movies = readCsv();
        if (movies == null) {
            System.out.println("Error reading CSV file");
            return;
        }

        // if (movies != null) {
        //     // for (String[] movie : movies) {

        //     // }
        //     // System.out.println("Total movies: " + movies.size()); // movies count
            
        // }

        List<String[]> movie = getMovieByName("Ma");
            if (movie != null) {
                for (String[] m : movie) {
                    // Display results as table in console row by row cols
                    System.out.println("ID: " + m[0] + " | Type: " + m[1] + " | Title: " + m[2] + " | Director: " + m[3]);
                }
            } else {
                System.out.println("Movie not found");
            }

        System.out.println(
                "\n ─▄▀─▄▀ Netflix Movie CLI\n" +
                        " ──▀──▀\n" +
                        " █▀▀▀▀▀█▄\n" +
                        " █░░░░░█─█\n" +
                        " ▀▄▄▄▄▄▀▀\n");

        CommandLine commandLine = new CommandLine(new CLI());
        // commandLine.execute(args);
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
        List<String[]> foundMovies = null;
        if (movies != null) {
            for (String[] movie : movies) {
                
                if (movie[2].toLowerCase().contains(name.toLowerCase())) {
                    if (foundMovies == null) {
                        foundMovies = new ArrayList<>();
                    }
                    foundMovies.add(movie);
                }
            }
        }
        return foundMovies;
    }

}
