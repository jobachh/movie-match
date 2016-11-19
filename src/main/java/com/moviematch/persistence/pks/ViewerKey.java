package com.moviematch.persistence.pks;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ViewerKey implements Serializable {

    private static final long serialVersionUID = 1L;

    private long recId;
    private int viewerNumber;

    public ViewerKey() {

    }

    public ViewerKey(long recId, int viewerNumber) {
        this.recId = recId;
        this.viewerNumber = viewerNumber;
    }

    public long getRecId() {
        return recId;
    }

    public void setRecId(long recId) {
        this.recId = recId;
    }

    public int getViewerNumber() {
        return viewerNumber;
    }

    public void setViewerNumber(int viewerNumber) {
        this.viewerNumber = viewerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViewerKey)) return false;

        ViewerKey viewerKey = (ViewerKey) o;

        if (recId != viewerKey.recId) return false;
        return viewerNumber == viewerKey.viewerNumber;

    }

    @Override
    public int hashCode() {
        int result = (int) (recId ^ (recId >>> 32));
        result = 31 * result + viewerNumber;
        return result;
    }

    @Override
    public String toString() {
        return "ViewerKey{" +
                "recId=" + recId +
                ", viewerNumber=" + viewerNumber +
                '}';
    }
}
