package com.perfectmatch.persistence.model;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@ApiModel(description = "Details of the match - first step process without envolving music samples")
public class Match implements NameableEntity, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -9166396470466850949L;

  @Id private String id;

  @NotNull
  @NotBlank
  @ApiModelProperty(notes = "Name of the music 1")
  private String musicNameThis;

  @NotNull
  @NotBlank
  @ApiModelProperty(notes = "Name of the music 2")
  private String musicNameThat;

  @NotNull
  @NotBlank
  @ApiModelProperty(notes = "Rule used in the match, default is by key and same artist ")
  private String rule;

  /*
   * (non-Javadoc)
   *
   * @see com.perfectmatch.common.interfaces.ByNameQueryable#getName()
   */
  @Override
  @JsonIgnore
  public String getName() {
    return this.musicNameThis + "," + this.musicNameThat;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {

    return Objects.hash(id, rule, musicNameThis, musicNameThat);
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
    return id == other.id
        && Objects.equals(rule, other.rule)
        && Objects.equals(musicNameThis, other.musicNameThis)
        && Objects.equals(musicNameThat, other.musicNameThat);
  }
}
