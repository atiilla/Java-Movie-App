package com.netflix;

/*
 * Movie class to store movie details
 * @Params name, category, director, release_date, review
 * @Return name, category, director, release_date, review
 * @Override toString
*/
public class Movie {
    private String name;
    private String category;
    private String director;
    private String release_date;
    private String review;

    public Movie(String name, String category, String director, String review, String release_date) {
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

    public String getRelease_date() {
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

    public void setRelease_date(String release_date) {
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
