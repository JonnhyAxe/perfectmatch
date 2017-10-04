package com.perfectmatch.persistence.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.perfectmatch.common.model.NameableEntity;

/**
 *
 * Represents an match between two samples
 *
 */
@Entity
@Table(name = "MATCH")
public class Match implements NameableEntity, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9166396470466850949L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MATCH_ID")
    private Long id;


    @Column(name = "NAME", nullable = false)
    private String name;


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
     * @see com.perfectmatch.common.interfaces.ByNameQueryable#getName()
     */
    @Override
    public String getName() {

        // TODO Auto-generated method stub
        return null;
    }

    @Column(name = "SAMPLE_TO", nullable = false)
    private String sampleFromRule;


    @Column(name = "RULE", nullable = false)
    private String rule;



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
        result = prime * result + (name == null ? 0 : name.hashCode());
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
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
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
