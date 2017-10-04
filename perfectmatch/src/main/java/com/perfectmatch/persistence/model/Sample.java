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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.perfectmatch.common.model.NameableEntity;

/**
 * This class represents an Sample of one specific music
 *
 */
@Entity
@Table(name = "SAMPLE")
public class Sample implements NameableEntity {


    /**
     *
     */
    private static final long serialVersionUID = -4288830678875960178L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAMPLE_ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;


    @Column(name = "TIMESTAMP", nullable = false)
    private int timestamp;

    // @formatter:off
    @ManyToMany( /* cascade = { CascadeType.REMOVE }, */fetch = FetchType.EAGER)
    @JoinTable(name = "SAMPLE_MATCH", joinColumns = { @JoinColumn(name = "SAMPLE_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "MATCH_ID") })
    private Set<Match> mathes;

    /**
     * @return the mathes
     */
    public Set<Match> getMathes() {

        return mathes;
    }

    /**
     * @param mathes
     *            the mathes to set
     */
    public void setMathes(Set<Match> mathes) {

        this.mathes = mathes;
    }

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
        result = prime * result + (mathes == null ? 0 : mathes.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
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
        if (mathes == null) {
            if (other.mathes != null) {
                return false;
            }
        }
        else if (!mathes.equals(other.mathes)) {
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
        if (timestamp != other.timestamp) {
            return false;
        }
        return true;
    }


}
