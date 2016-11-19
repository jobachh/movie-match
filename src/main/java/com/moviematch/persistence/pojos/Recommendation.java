package com.moviematch.persistence.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recommendation {

    private @Id @GeneratedValue Long recId;

    public Long getRecId() {
        return recId;
    }

    public void setRecId(Long recId) {
        this.recId = recId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recommendation)) return false;

        Recommendation that = (Recommendation) o;

        return recId.equals(that.recId);
    }

    @Override
    public int hashCode() {
        return recId.hashCode();
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "recId=" + recId +
                '}';
    }
}
