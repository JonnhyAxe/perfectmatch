package com.perfectmatch.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * /** Represents an match between two samples
 *
 */
@Entity
@Table(name = "SAMPLE_MATCH")
public class Match {

    @Id
    @Column(name = "SAMPLE1", nullable = false)
    private String sample1;

    // TODO: @Id
    @Column(name = "SAMPLE2", nullable = false)
    private String sample2;

    @Column(name = "RULE", nullable = false)
    private String rule;

    /**
     * @return the sample1
     */
    public String getSample1() {

        return sample1;
    }

    /**
     * @param sample1
     *            the sample1 to set
     */
    public void setSample1(String sample1) {

        this.sample1 = sample1;
    }

    /**
     * @return the sample2
     */
    public String getSample2() {

        return sample2;
    }

    /**
     * @param sample2
     *            the sample2 to set
     */
    public void setSample2(String sample2) {

        this.sample2 = sample2;
    }



    /**
     * @return the rule
     */
    public String getRule() {

        return rule;
    }

    /**
     * @param rule
     *            the rule to set
     */
    public void setRule(String rule) {

        this.rule = rule;
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
        result = prime * result + (sample1 == null ? 0 : sample1.hashCode());
        result = prime * result + (sample2 == null ? 0 : sample2.hashCode());
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
        Match other = (Match) obj;
        if (sample1 == null) {
            if (other.sample1 != null) {
                return false;
            }
        }
        else if (!sample1.equals(other.sample1)) {
            return false;
        }
        if (sample2 == null) {
            if (other.sample2 != null) {
                return false;
            }
        }
        else if (!sample2.equals(other.sample2)) {
            return false;
        }
        return true;
    }

}
