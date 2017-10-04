package com.perfectmatch.persistence.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.model.NameableEntity;

/**
 *
 * This class represents an Music to sample from
 *
 */
@Entity
@Table(name = "MUSIC")
public class Music implements NameableEntity, ByArtistQueryable {

    /**
     *
     */
    private static final long serialVersionUID = -6021901171439734300L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MUSIC_ID")
    private Long id;


    @Column(name = "ARTIST", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String artist;

    @Column(name = "NAME", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "STYLE", nullable = false)
    @NotNull
    @Size(min = 2, max = 50)
    private String style;


    @OneToMany( /* cascade = { CascadeType.REMOVE }, */fetch = FetchType.EAGER)
    @JoinTable(name = "MUSIC_SAMPLE", joinColumns = { @JoinColumn(name = "MUSIC_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SAMPLE_ID") })
    private Set<Sample> samples;


    /**
     * @return the id
     */
    @Override
    public Long getId() {

        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {

        this.id = id;
    }

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


    /**
     * @return the samples
     */
    public Set<Sample> getSamples() {

        return samples;
    }

    /**
     * @param samples
     *            the samples to set
     */
    public void setSamples(Set<Sample> samples) {

        this.samples = samples;
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
