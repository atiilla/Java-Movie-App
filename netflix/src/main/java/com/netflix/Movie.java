package com.netflix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Movie {
    private String show_id;
    private String type;
    private String title;
    private String director;
    private String cast;
    private String country;
    private String date_added;
    private int release_year;
    private String rating;
    private String duration;
    private String listed_in;
    private String description;
    private List<String> review;

    public Movie(String show_id, String type, String title, String director, String cast, String country,
                 String date_added, int release_year, String rating, String duration, String listed_in, String description, List<String> review) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date_added = date_added;
        this.release_year = release_year;
        this.rating = rating;
        this.duration = duration;
        this.listed_in = listed_in;
        this.description = description;
        this.review = review != null ? review : new ArrayList<>();
    }

    public Movie() {
        this.review = new ArrayList<>();
    }

    public String getId() {

        return show_id;

    }

    public List<String> getReview() {
        return review;
    }

    public void setReviewFromString(String reviewString) {
        if (reviewString != null && !reviewString.isEmpty()) {
            this.review = Arrays.asList(reviewString.split("\\|"));
        } else {
            this.review = new ArrayList<>();
        }
    }

    public String getReviewAsString() {
        return String.join("|", this.review);
    }

    public void addReview(String comment) {
        if (comment != null && !comment.trim().isEmpty()) {
            this.review.add(comment);
        } else {
            throw new IllegalArgumentException("Review comment cannot be null or empty.");
        }
    }

    @Override
    public String toString() {
        return "Movie{" +
                "show_id='" + show_id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", country='" + country + '\'' +
                ", date_added='" + date_added + '\'' +
                ", release_year=" + release_year +
                ", rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", listed_in='" + listed_in + '\'' +
                ", description='" + description + '\'' +
                ", reviews=" + (review.isEmpty() ? "No reviews yet" : review) +
                '}';
    }
}
