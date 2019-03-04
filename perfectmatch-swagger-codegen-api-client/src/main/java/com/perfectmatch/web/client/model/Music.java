/*
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.perfectmatch.web.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.perfectmatch.web.client.model.Sample;
import com.perfectmatch.web.client.model.URL;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * All details about the music 
 */
@ApiModel(description = "All details about the music ")
public class Music {
  @JsonProperty("artists")
  private List<String> artists = null;

  @JsonProperty("energy")
  private String energy = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("key")
  private String key = null;

  @JsonProperty("location")
  private URL location = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("recordLabel")
  private String recordLabel = null;

  @JsonProperty("remixers")
  private List<String> remixers = null;

  @JsonProperty("samples")
  private List<Sample> samples = null;

  @JsonProperty("style")
  private String style = null;

  @JsonProperty("tempo")
  private String tempo = null;

  public Music artists(List<String> artists) {
    this.artists = artists;
    return this;
  }

  public Music addArtistsItem(String artistsItem) {
    if (this.artists == null) {
      this.artists = new ArrayList<String>();
    }
    this.artists.add(artistsItem);
    return this;
  }

   /**
   * Names of the music artist - without contrains
   * @return artists
  **/
  @ApiModelProperty(value = "Names of the music artist - without contrains")
  public List<String> getArtists() {
    return artists;
  }

  public void setArtists(List<String> artists) {
    this.artists = artists;
  }

  public Music energy(String energy) {
    this.energy = energy;
    return this;
  }

   /**
   * Energy of the music
   * @return energy
  **/
  @ApiModelProperty(value = "Energy of the music")
  public String getEnergy() {
    return energy;
  }

  public void setEnergy(String energy) {
    this.energy = energy;
  }

  public Music id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Music key(String key) {
    this.key = key;
    return this;
  }

   /**
   * key of the music
   * @return key
  **/
  @ApiModelProperty(value = "key of the music")
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public Music location(URL location) {
    this.location = location;
    return this;
  }

   /**
   * Location of the file in the storage
   * @return location
  **/
  @ApiModelProperty(value = "Location of the file in the storage")
  public URL getLocation() {
    return location;
  }

  public void setLocation(URL location) {
    this.location = location;
  }

  public Music name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the music - without format contrains
   * @return name
  **/
  @ApiModelProperty(value = "Name of the music - without format contrains")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Music recordLabel(String recordLabel) {
    this.recordLabel = recordLabel;
    return this;
  }

   /**
   * Record Label name
   * @return recordLabel
  **/
  @ApiModelProperty(value = "Record Label name")
  public String getRecordLabel() {
    return recordLabel;
  }

  public void setRecordLabel(String recordLabel) {
    this.recordLabel = recordLabel;
  }

  public Music remixers(List<String> remixers) {
    this.remixers = remixers;
    return this;
  }

  public Music addRemixersItem(String remixersItem) {
    if (this.remixers == null) {
      this.remixers = new ArrayList<String>();
    }
    this.remixers.add(remixersItem);
    return this;
  }

   /**
   * Names of the remixers artist - without contrains
   * @return remixers
  **/
  @ApiModelProperty(value = "Names of the remixers artist - without contrains")
  public List<String> getRemixers() {
    return remixers;
  }

  public void setRemixers(List<String> remixers) {
    this.remixers = remixers;
  }

  public Music samples(List<Sample> samples) {
    this.samples = samples;
    return this;
  }

  public Music addSamplesItem(Sample samplesItem) {
    if (this.samples == null) {
      this.samples = new ArrayList<Sample>();
    }
    this.samples.add(samplesItem);
    return this;
  }

   /**
   * Samples of the music - at least one sample
   * @return samples
  **/
  @ApiModelProperty(value = "Samples of the music - at least one sample")
  public List<Sample> getSamples() {
    return samples;
  }

  public void setSamples(List<Sample> samples) {
    this.samples = samples;
  }

  public Music style(String style) {
    this.style = style;
    return this;
  }

   /**
   * Style of the music of type Style
   * @return style
  **/
  @ApiModelProperty(value = "Style of the music of type Style")
  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public Music tempo(String tempo) {
    this.tempo = tempo;
    return this;
  }

   /**
   * Tempo of the music
   * @return tempo
  **/
  @ApiModelProperty(value = "Tempo of the music")
  public String getTempo() {
    return tempo;
  }

  public void setTempo(String tempo) {
    this.tempo = tempo;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Music music = (Music) o;
    return Objects.equals(this.artists, music.artists) &&
        Objects.equals(this.energy, music.energy) &&
        Objects.equals(this.id, music.id) &&
        Objects.equals(this.key, music.key) &&
        Objects.equals(this.location, music.location) &&
        Objects.equals(this.name, music.name) &&
        Objects.equals(this.recordLabel, music.recordLabel) &&
        Objects.equals(this.remixers, music.remixers) &&
        Objects.equals(this.samples, music.samples) &&
        Objects.equals(this.style, music.style) &&
        Objects.equals(this.tempo, music.tempo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(artists, energy, id, key, location, name, recordLabel, remixers, samples, style, tempo);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Music {\n");
    
    sb.append("    artists: ").append(toIndentedString(artists)).append("\n");
    sb.append("    energy: ").append(toIndentedString(energy)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    recordLabel: ").append(toIndentedString(recordLabel)).append("\n");
    sb.append("    remixers: ").append(toIndentedString(remixers)).append("\n");
    sb.append("    samples: ").append(toIndentedString(samples)).append("\n");
    sb.append("    style: ").append(toIndentedString(style)).append("\n");
    sb.append("    tempo: ").append(toIndentedString(tempo)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
