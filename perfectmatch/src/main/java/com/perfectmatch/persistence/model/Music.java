package com.perfectmatch.persistence.model;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.interfaces.MetaDataQueryable;
import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * This class represents an Music to sample from
 *
 */
@ApiModel(description="All details about the music ")
public class Music implements NameableEntity, ByArtistQueryable, MetaDataQueryable {

    /**
     *
     */
    private static final long serialVersionUID = -6021901171439734300L;

    @Id
    private String id;

	@ApiModelProperty(notes="Names of the music artist - without contrains")
    private List<String> artists;

//	@NotNull TODO: add this
	@ApiModelProperty(notes="Name of the music - without format contrains")
	private String name;
	
//	@NotNull TODO: add this
	@ApiModelProperty(notes="Style of the music of type Style")
    private String style;

	@ApiModelProperty(notes="Samples of the music - at least one sample")
    private Set<Sample> samples = new HashSet<>();
	
	@ApiModelProperty(notes="Names of the remixers artist - without contrains")
    private Set<String> remixers = new HashSet<>();

	@ApiModelProperty(notes="Record Label name")
    private String recordLabel;

	@ApiModelProperty(notes="key of the music")
	private String key;

	@ApiModelProperty(notes="Energy of the music")
	private String energy;

	@ApiModelProperty(notes="Tempo of the music")
	private String tempo;
	
	@ApiModelProperty(notes="Location of the file in the storage")
	private URL location;

	public String getStyle() {
		return style;
	}

	public Set<Sample> getSamples() {
		return samples;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
     * @return the id
     */
    @Override
    public String getId() {

        return id;
    }

    public void setArtists(List<String> artists) {
		this.artists = artists;
	}

    
    /**
     * @return the artist
     */
    @Override
    public List<String> getArtists() {
        return artists;
    }
    
    /**
     * @return the artist
     */
    @Override
    public String getArtist() {
        return artists.get(0); //TODO: remove this
    }
    

	@Override
	public String getKey() {
		return this.key;
	}

	@Override
	public String getEnergy() {
		return this.energy;
	}

	@Override
	public String getTempo() {
		return this.tempo;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setEnergy(String energy) {
		this.energy = energy;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
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


	public Set<String> getRemixers() {
		return remixers;
	}

	public void setRemixers(Set<String> remixers) {
		this.remixers = remixers;
	}


	public String getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(String record) {
		this.recordLabel = record;
	}
	
	public URL getLocation() {
		return location;
	}

	public void setLocation(URL location) {
		this.location = location;
	}
	
    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.artists, this.id, this.name, this.remixers);
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
        		Objects.equals(artists, other.artists) && 
        		Objects.equals(name, other.name) && 
        		Objects.equals(style, other.style) &&
        		Objects.equals(remixers, other.remixers)
        		;
    }




}
