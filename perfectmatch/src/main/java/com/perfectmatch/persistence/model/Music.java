package com.perfectmatch.persistence.model;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.interfaces.MetaDataQueryable;
import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * This class represents an Music to sample from
 *
 */
@Getter 
@Setter 
@NoArgsConstructor 
@ApiModel(description = "All details about the music ")
public class Music implements NameableEntity, ByArtistQueryable, MetaDataQueryable {

  /**
   *
   */
  private static final long serialVersionUID = -6021901171439734300L;

  @Id private String id;

  @NotNull
  @ApiModelProperty(notes = "Names of the music artist - without contrains")
  private List<String> artists;

  @NotNull
  @ApiModelProperty(notes = "Name of the music - without format contrains")
  private String name;

  @ApiModelProperty(notes = "Style of the music of type Style")
  @NotNull
  private String style; //grouping

  @ApiModelProperty(notes = "Samples of the music - at least one sample")
  private Set<Sample> samples = new HashSet<>();

  @ApiModelProperty(notes = "Names of the remixers artist - without contrains")
  private Set<String> remixers = new HashSet<>();

  @ApiModelProperty(notes = "Record Label name")
  private String recordLabel;

  @ApiModelProperty(notes = "key of the music")
  @NotNull
  private String key;

  @ApiModelProperty(notes = "Energy of the music")
  @NotNull
  private String energy; //grouping

  @ApiModelProperty(notes = "Tempo of the music")
  @NotNull
  private String tempo;

  @ApiModelProperty(notes = "Location of the file in the storage")
  @NotNull
  private URL location;

 
  /**
   * @return the artists
   */
  @Override
  @JsonIgnore
  public String getArtist() {
    return Objects.nonNull(getArtists()) && getArtists().size() > 0 ? getArtistNames() : null;
  }

  private String getArtistNames() {

	  return StringUtils.collectionToDelimitedString(artists, ",");
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

    return Objects.equals(id, other.id)
        && Objects.equals(artists, other.artists)
        && Objects.equals(name, other.name)
        && Objects.equals(style, other.style)
        && Objects.equals(remixers, other.remixers);
  }
}
