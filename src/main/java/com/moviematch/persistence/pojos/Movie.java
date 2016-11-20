package com.moviematch.persistence.pojos;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Movie {

    private @Id @GeneratedValue long movieId;
    private String name;
    private int year;
    private String description;
    private String imageUrl;
    private String trailerUrl;
    private float rating;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "movies_genres",
        joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    public Movie() {

    }

    public Movie(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;

        Movie movie = (Movie) o;

        if (movieId != movie.movieId) return false;
        if (year != movie.year) return false;
        if (Float.compare(movie.rating, rating) != 0) return false;
        if (name != null ? !name.equals(movie.name) : movie.name != null) return false;
        if (description != null ? !description.equals(movie.description) : movie.description != null) return false;
        if (imageUrl != null ? !imageUrl.equals(movie.imageUrl) : movie.imageUrl != null) return false;
        return trailerUrl != null ? trailerUrl.equals(movie.trailerUrl) : movie.trailerUrl == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (movieId ^ (movieId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (trailerUrl != null ? trailerUrl.hashCode() : 0);
        result = 31 * result + (rating != +0.0f ? Float.floatToIntBits(rating) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", rating=" + rating +
                '}';
    }
}

