package com.netflix;

import java.util.Date;

public class Movie {
    private String name;
    private String category;
    private String director;
    private Date release_date;
    private String review;

    public Movie(String name, String category, String director, Date release_date, String review) {
        this.name = name;
        this.category = category;
        this.director = director;
        this.release_date = release_date;
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public String getReview() {
        return review;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", director='" + director + '\'' +
                ", release_date=" + release_date +
                ", review='" + review + '\'' +
                '}';
    }
    

}
