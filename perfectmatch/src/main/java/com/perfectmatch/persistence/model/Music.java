package com.perfectmatch.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.interfaces.ByNameQueryable;

/**
 * This class represents an Music to sample froms
 *
 */
@Entity
@Table(name = "MUSIC")
public class Music implements ByNameQueryable, ByArtistQueryable {


    @Column(name = "ARTIST", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String artist;

    @Id
    @Column(name = "NAME", unique = true, nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "STYLE", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String style;

    /**
     * @return the artist
     */
    @Override
    public String getArtist() {

        return artist;
    }


    /**
     * @param artist
     *            the artist to set
     */
    public void setArtist(String artist) {

        this.artist = artist;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() {

        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {

        this.name = name;
    }

    /**
     * @return the style
     */
    public String getStyle() {

        return style;
    }

    /**
     * @param style
     *            the style to set
     */
    public void setStyle(String style) {

        this.style = style;
    }


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + (artist == null ? 0 : artist.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (style == null ? 0 : style.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Music other = (Music) obj;
        if (artist == null) {
            if (other.artist != null) {
                return false;
            }
        }
        else if (!artist.equals(other.artist)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (style == null) {
            if (other.style != null) {
                return false;
            }
        }
        else if (!style.equals(other.style)) {
            return false;
        }
        return true;
    }
}
