package com.moviematch.persistence.pojos;

import com.moviematch.persistence.pks.ViewerKey;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Viewer {

    private @EmbeddedId ViewerKey viewerKey;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "viewers_genres",
            joinColumns = {@JoinColumn(name = "rec_id"), @JoinColumn(name = "viewer_number")},
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;

    public ViewerKey getViewerKey() {
        return viewerKey;
    }

    public void setViewerKey(ViewerKey viewerKey) {
        this.viewerKey = viewerKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Viewer)) return false;

        Viewer viewer = (Viewer) o;

        if (!viewerKey.equals(viewer.viewerKey)) return false;
        return name != null ? name.equals(viewer.name) : viewer.name == null;

    }

    @Override
    public int hashCode() {
        int result = viewerKey.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "viewerKey=" + viewerKey +
                ", name='" + name + '\'' +
                ", genres=" + genres +
                '}';
    }
}
