package com.perfectmatch.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * This class represents an Sample of one specific music
 *
 */
@Entity
@Table(name = "SAMPLE")
public class Sample implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;


    @Column(name = "STYLE", nullable = false)
    private String style;

    /**
     * @return the id
     */
    public String getId() {

        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {

        this.id = id;
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
        result = prime * result + (id == null ? 0 : id.hashCode());
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
        Sample other = (Sample) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        }
        else if (!id.equals(other.id)) {
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
