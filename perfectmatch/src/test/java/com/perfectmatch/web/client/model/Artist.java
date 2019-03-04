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
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * All details about the artist 
 */
@ApiModel(description = "All details about the artist ")
public class Artist {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("websites")
  private List<String> websites = null;

  public Artist id(String id) {
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

  public Artist name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the artist - without format contrains
   * @return name
  **/
  @ApiModelProperty(value = "Name of the artist - without format contrains")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Artist websites(List<String> websites) {
    this.websites = websites;
    return this;
  }

  public Artist addWebsitesItem(String websitesItem) {
    if (this.websites == null) {
      this.websites = new ArrayList<String>();
    }
    this.websites.add(websitesItem);
    return this;
  }

   /**
   * Websites of the artist - without format contrains
   * @return websites
  **/
  @ApiModelProperty(value = "Websites of the artist - without format contrains")
  public List<String> getWebsites() {
    return websites;
  }

  public void setWebsites(List<String> websites) {
    this.websites = websites;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Artist artist = (Artist) o;
    return Objects.equals(this.id, artist.id) &&
        Objects.equals(this.name, artist.name) &&
        Objects.equals(this.websites, artist.websites);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, websites);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Artist {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    websites: ").append(toIndentedString(websites)).append("\n");
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

