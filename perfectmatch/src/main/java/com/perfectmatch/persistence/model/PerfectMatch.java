package com.perfectmatch.persistence.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 *
 * Represents an match between two samples
 *
 */

@Getter
@Setter
@ToString
@ApiModel(description="Details of the match - second step process envolving music samples")
public class PerfectMatch implements NameableEntity, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -9166396470466850949L;

    @Id
    private String id;
	
    @ApiModelProperty(notes="Sample of the music 1")
    private String sampleMusicThis;
	
    @ApiModelProperty(notes="Sample of the music 2")
    private String sampleMusicThat;
	
    @ApiModelProperty(notes="Rule used in the match, default is by key and same artist ")
    private String rule;


    /*
     * (non-Javadoc)
     *
     * @see com.perfectmatch.common.interfaces.ByNameQueryable#getName()
     */
    @Override
    public String getName() {
        return this.sampleMusicThis + "," + this.sampleMusicThat;
    }


    /**
     * @return the id
     */
    @Override
    public String getId() {

        return id;
    }


	public String getSampleMusicThis() {
		return sampleMusicThis;
	}


	public void setSampleMusicThis(String sampleMusicThis) {
		this.sampleMusicThis = sampleMusicThis;
	}


	public String getSampleMusicThat() {
		return sampleMusicThat;
	}


	public void setSampleMusicThat(String sampleMusicThat) {
		this.sampleMusicThat = sampleMusicThat;
	}


	public void setSampleFromRule(String sampleFromRule) {
		this.sampleMusicThat = sampleFromRule;
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

        return Objects.hash(id, rule, sampleMusicThis, sampleMusicThat);
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
        PerfectMatch other = (PerfectMatch) obj;
        return id == other.id && 
        		Objects.equals(rule, other.rule) && 
        		Objects.equals(sampleMusicThis, other.sampleMusicThis) && 
        		Objects.equals(sampleMusicThat, other.sampleMusicThat);

    }

}
