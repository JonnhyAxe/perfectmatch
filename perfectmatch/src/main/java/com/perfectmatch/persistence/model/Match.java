package com.perfectmatch.persistence.model;

import java.io.Serializable;
import java.util.Objects;


import com.perfectmatch.common.model.NameableEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
/**
 *
 * Represents an match between two samples
 *
 */

@Getter
@Setter
@ToString
public class Match implements NameableEntity, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9166396470466850949L;

    @Id
    private String id;
    private String name;
    private String sampleFromRule;
    private String rule;


    /*
     * (non-Javadoc)
     *
     * @see com.perfectmatch.common.interfaces.ByNameQueryable#getName()
     */
    @Override
    public String getName() {

        // TODO Auto-generated method stub
        return this.name;
    }


    /**
     * @return the id
     */
    @Override
    public String getId() {

        return id;
    }


    public void setName(String name) {
		this.name = name;
	}



	public void setSampleFromRule(String sampleFromRule) {
		this.sampleFromRule = sampleFromRule;
	}



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

        return Objects.hash(id, rule, name, sampleFromRule);
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
        return id == other.id && 
        		Objects.equals(rule, other.rule) && 
        		Objects.equals(name, other.name) && 
        		Objects.equals(sampleFromRule, other.sampleFromRule);

    }

}
