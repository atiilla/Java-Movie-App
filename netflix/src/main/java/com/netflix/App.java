package com.netflix;

import picocli.CommandLine;

/*
  Main class for Netflix Movie CLI
*/
public class App {

    public static void main(String[] args) {

        // List<String[]> movies = readCsv();
        // if (movies == null) {
        // System.out.println("Error reading CSV file");
        // return;
        // }

        // if (movies != null) {
        // // for (String[] movie : movies) {

        // // }
        // // System.out.println("Total movies: " + movies.size()); // movies count

        // }

        // List<String[]> movie = getMovieByName("Ma");
        // if (movie != null) {
        // for (String[] m : movie) {
        // // Display results as table in console row by row cols
        // System.out.println("ID: " + m[0] + " | Type: " + m[1] + " | Title: " + m[2] +
        // " | Director: " + m[3]);
        // }
        // } else {
        // System.out.println("Movie not found");
        // }

        System.out.println(
                "\n ─▄▀─▄▀ Netflix Movie CLI\n" +
                        " ──▀──▀\n" +
                        " █▀▀▀▀▀█▄\n" +
                        " █░░░░░█─█\n" +
                        " ▀▄▄▄▄▄▀▀\n");

        CommandLine commandLine = new CommandLine(new CLI());
        commandLine.execute(args);
    }

}
