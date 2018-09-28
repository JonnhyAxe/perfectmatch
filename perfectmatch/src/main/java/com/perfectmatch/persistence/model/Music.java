package com.perfectmatch.persistence.model;

import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * This class represents an Music to sample from
 *
 */
@ApiModel(description="All details about the music ")
public class Music implements NameableEntity, ByArtistQueryable {

    /**
     *
     */
    private static final long serialVersionUID = -6021901171439734300L;

    @Id
    private String id;

	@ApiModelProperty(notes="Name of the music artis - without format contrains")
    private String artist;

	@ApiModelProperty(notes="Name of the music - without format contrains")
	private String name;

	@ApiModelProperty(notes="Style of the music of type Style")
    private String style;

	@ApiModelProperty(notes="Samples of the music - at least one sample")
    private Set<Sample> samples;


    /**
     * @return the id
     */
    @Override
    public String getId() {

        return id;
    }

    public void setArtist(String artist) {
		this.artist = artist;
	}

    
    /**
     * @return the artist
     */
    @Override
    public String getArtist() {

        return artist;
    }
    


	public void setName(String name) {
		this.name = name;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setSamples(Set<Sample> samples) {
		this.samples = samples;
	}

	@Override
	public String getName() {
		return name;
	}


    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {


        return Objects.hash(this.artist, this.id, this.name, this.samples);
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
       
        return Objects.equals(id, other.id) && 
        		Objects.equals(artist, other.artist) && 
        		Objects.equals(name, other.name) && 
        		Objects.equals(style, other.style) &&
        		Objects.equals(samples, other.samples);
    }


}
