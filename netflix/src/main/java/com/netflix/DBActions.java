package com.netflix;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

// show_id,type,title,director,cast,country,date_added,release_year,rating,duration,listed_in,description
public class DBActions {
    private static final String FILE_PATH = "src/main/resources/netflix_titles.csv";

    public static void listbyName(String name) {
        List<String[]> movie = getMovieByName(name);
        if (movie != null) {
            for (String[] m : movie) {
                System.out.println("ID: " + m[0] + " | Type: " + m[1] + " | Title: " + m[2] + " | Director: " + m[3]);
            }
        } else {
            System.out.println("Movie not found");
        }

    }

    public static void listByDirector(String director) {
        List<String[]> movie = getMovieByDirector(director);
        if (movie != null) {
            for (String[] m : movie) {
                System.out.println("ID: " + m[0] + " | Type: " + m[1] + " | Title: " + m[2] + " | Director: " + m[3]);
            }
        } else {
            System.out.println("Movie not found");
        }
    }

    public static void listByCategory(String category) {
        List<String[]> movie = getMovieByCategory(category);
        if (movie != null) {
            for (String[] m : movie) {
                System.out.println("ID: " + m[0] + " | Type: " + m[1] + " | Title: " + m[2] + " | Director: " + m[3]);
            }
        } else {
            System.out.println("Movie not found");
        }
    }

    public static void listByReleaseDate(String release_date) {
        List<String[]> movie = getMovieByReleaseDate(release_date);
        if (movie != null) {
            for (String[] m : movie) {
                System.out.println("ID: " + m[0] + " | Type: " + m[1] + " | Title: " + m[2] + " | Director: " + m[3]);
            }
        } else {
            System.out.println("Movie not found");
        }
    }

    public static void listAll(int limit, int page) {
        List<String[]> movies = readCsv();
        if (movies != null) {
            int start = (page - 1) * limit;
            int end = Math.min(start + limit, movies.size());
            for (int i = start; i < end; i++) {
                String[] movie = movies.get(i);
                System.out.println("ID: " + movie[0] + " | Type: " + movie[1] + " | Title: " + movie[2]
                        + " | Director: " + movie[3]);
            }
        }
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

    public static List<String[]> getMovieByDirector(String director) {
        List<String[]> movies = readCsv();
        List<String[]> foundMovies = null;
        if (movies != null) {
            for (String[] movie : movies) {
                if (movie[3].toLowerCase().contains(director.toLowerCase())) {
                    if (foundMovies == null) {
                        foundMovies = new ArrayList<>();
                    }
                    foundMovies.add(movie);
                }
            }
        }
        return foundMovies;
    }

    public static List<String[]> getMovieByCategory(String category) {
        List<String[]> movies = readCsv();
        List<String[]> foundMovies = null;
        if (movies != null) {
            for (String[] movie : movies) {
                if (movie[10].toLowerCase().contains(category.toLowerCase())) {
                    if (foundMovies == null) {
                        foundMovies = new ArrayList<>();
                    }
                    foundMovies.add(movie);
                }
            }
        }
        return foundMovies;
    }

    public static List<String[]> getMovieByReleaseDate(String release_date) {
        List<String[]> movies = readCsv();
        List<String[]> foundMovies = null;
        if (movies != null) {
            for (String[] movie : movies) {
                if (movie[6].toLowerCase().contains(release_date.toLowerCase())) {
                    if (foundMovies == null) {
                        foundMovies = new ArrayList<>();
                    }
                    foundMovies.add(movie);
                }
            }
        }
        return foundMovies;
    }

    // get random 100 movies
    public static List<String[]> getRandomMovies() {
        List<String[]> movies = readCsv();
        List<String[]> randomMovies = new ArrayList<>();
        if (movies != null) {
            for (int i = 0; i < 100; i++) {
                randomMovies.add(movies.get(i));
            }
        }
        return randomMovies;
    }

    public static int generateMovieShowId() {
        List<String[]> movies = readCsv();
        // get the last movie show_id
        String lastShowId = movies.get(movies.size() - 1)[0];
        // increment the last show_id by 1
        int newShowId = Integer.parseInt(lastShowId) + 1;
        System.out.println("New show_id: " + newShowId);
        return newShowId;
    }

    public static Movie findMovieById(String id) {
        List<String[]> movies = readCsv();

        if (movies != null) {
            for (String[] movie : movies) {
                if (movie[0].equals(id)) {
                    // Ensure the array has at least 13 elements before accessing index 12
                    List<String> reviews = movie.length > 12 && movie[12] != null
                            ? Arrays.asList(movie[12].split("\\|"))
                            : new ArrayList<>();
                    return new Movie(
                            movie[0], movie[1], movie[2], movie[3], movie[4], movie[5], movie[6],
                            Integer.parseInt(movie[7]), movie[8], movie[9], movie[10], movie[11], reviews);
                }
            }
        }
        System.out.println("Movie not found");
        return null;
    }

    public static void addReview(String showId, String comment) {
        Movie movie = findMovieById(showId);
        if (movie == null) {
            System.out.println("Movie not found. Cannot add review.");
            return;
        }
    
        // Add my comment to the movie 
        try {
            movie.addReview(comment);
            System.out.println("Review added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid review comment: " + e.getMessage());
            return;
        }
    
        // Save the updated movie back to the CSV file (not implemented in this snippet)
        System.out.println("Updated Movie: " + movie);
    }
    

}
