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
    @Column(name = "SAMPLE_FROM", nullable = false)
    private String sampleFrom;

    // TODO: @Id
    @Column(name = "SAMPLE_TO", nullable = false)
    private String sampleFromRule;

    @Column(name = "RULE", nullable = false)
    private String rule;

    /**
     * @return the sample1
     */
    public String getSample1() {

        return sampleFrom;
    }

    /**
     * @param sample1
     *            the sample1 to set
     */
    public void setSample1(String sample1) {

        this.sampleFrom = sample1;
    }

    /**
     * @return the sample2
     */
    public String getSample2() {

        return sampleFromRule;
    }

    /**
     * @param sample2
     *            the sample2 to set
     */
    public void setSample2(String sample2) {

        this.sampleFromRule = sample2;
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
        result = prime * result + (sampleFrom == null ? 0 : sampleFrom.hashCode());
        result = prime * result + (sampleFromRule == null ? 0 : sampleFromRule.hashCode());
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
        if (sampleFrom == null) {
            if (other.sampleFrom != null) {
                return false;
            }
        }
        else if (!sampleFrom.equals(other.sampleFrom)) {
            return false;
        }
        if (sampleFromRule == null) {
            if (other.sampleFromRule != null) {
                return false;
            }
        }
        else if (!sampleFromRule.equals(other.sampleFromRule)) {
            return false;
        }
        return true;
    }

}
