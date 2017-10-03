package com.perfectmatch.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * Represents an match between two samples
 *
 */
@Entity
@Table(name = "MATCH")
public class Match implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9166396470466850949L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MATCH_ID")
    private Long id;


    @Column(name = "SAMPLE_FROM", nullable = false)
    private String sampleFrom;


    @Column(name = "SAMPLE_TO", nullable = false)
    private String sampleFromRule;


    @Column(name = "RULE", nullable = false)
    private String rule;


    /**
     * @return the sampleFrom
     */
    public String getSampleFrom() {

        return sampleFrom;
    }

    /**
     * @param sampleFrom
     *            the sampleFrom to set
     */
    public void setSampleFrom(String sampleFrom) {

        this.sampleFrom = sampleFrom;
    }

    /**
     * @return the sampleFromRule
     */
    public String getSampleFromRule() {

        return sampleFromRule;
    }

    /**
     * @param sampleFromRule
     *            the sampleFromRule to set
     */
    public void setSampleFromRule(String sampleFromRule) {

        this.sampleFromRule = sampleFromRule;
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

    /**
     * @return the id
     */
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
        result = prime * result + (rule == null ? 0 : rule.hashCode());
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
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        }
        else if (!id.equals(other.id)) {
            return false;
        }
        if (rule == null) {
            if (other.rule != null) {
                return false;
            }
        }
        else if (!rule.equals(other.rule)) {
            return false;
        }
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
