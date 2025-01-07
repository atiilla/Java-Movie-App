package com.netflix;

import java.util.List;

/*
 * Movie class to store movie details
 * @Params show_id, type, title, director, cast, country, date_added, release_year, rating, duration, listed_in, description
 * @Return attributes through getters and setters
 * @Override toString
 */
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
        this.review = review;
    }

    public Movie(){

    }

    // Getters
    public String getShow_id() {
        return show_id;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getCast() {
        return cast;
    }

    public String getCountry() {
        return country;
    }

    public String getDate_added() {
        return date_added;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getRating() {
        return rating;
    }

    public String getDuration() {
        return duration;
    }

    public String getListed_in() {
        return listed_in;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getReview() {
        return review;
    }

    // Setters
    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setListed_in(String listed_in) {
        this.listed_in = listed_in;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReview(List<String> review) {
        this.review = review;
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
                ", review=" + review +
                '}';
    }
}
