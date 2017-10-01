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


/**
 * This class represents an Sample of one specific music
 *
 */
@Entity
@Table(name = "SAMPLE")
public class Sample {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAMPLE_ID", nullable = false)
    private String id;


    @Column(name = "TIMESTAMP", nullable = false)
    private int timestamp;

    // @formatter:off
    @OneToMany( /* cascade = { CascadeType.REMOVE }, */fetch = FetchType.EAGER)
    @JoinTable(name = "SAMPLE_MATH", joinColumns = { @JoinColumn(name = "SAMPLE_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "SAMPLE_FROM") })
    private Set<Match> mathes;

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
     * @return the timestamp
     */
    public int getTimestamp() {

        return timestamp;
    }

    /**
     * @param timestamp
     *            the timestamp to set
     */
    public void setTimestamp(int timestamp) {

        this.timestamp = timestamp;
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
        result = prime * result + timestamp;
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
        if (timestamp != other.timestamp) {
            return false;
        }
        return true;
    }


}
