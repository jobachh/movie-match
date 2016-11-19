package com.moviematch.persistence.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
    private @Id @GeneratedValue long genreId;
    private String name;

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;

        Genre genre = (Genre) o;

        if (genreId != genre.genreId) return false;
        return name != null ? name.equals(genre.name) : genre.name == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (genreId ^ (genreId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", name='" + name + '\'' +
                '}';
    }
}
