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

/**
 * Details of the match - second step process envolving music samples
 */
@ApiModel(description = "Details of the match - second step process envolving music samples")
public class PerfectMatch {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public PerfectMatch id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Id Match
   * @return id
  **/
  @ApiModelProperty(value = "Id Match")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PerfectMatch name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of Match
   * @return name
  **/
  @ApiModelProperty(value = "Name of Match")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PerfectMatch perfectMatch = (PerfectMatch) o;
    return Objects.equals(this.id, perfectMatch.id) &&
        Objects.equals(this.name, perfectMatch.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PerfectMatch {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
