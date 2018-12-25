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
@ApiModel(description = "Details of the match - second step process envolving music samples")
public class PerfectMatch implements NameableEntity, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -9166396470466850949L;

  @ApiModelProperty(notes = "Id Match")
  @Id private String id;

  @ApiModelProperty(notes = "Name Match id ")
  private String name;

  /*
   * (non-Javadoc)
   *
   * @see com.perfectmatch.common.interfaces.ByNameQueryable#getName()
   */
  @Override
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the id
   */
  @Override
  public String getId() {
    return id;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {

    return Objects.hash(id, name);
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
    return id == other.id && Objects.equals(name, other.name);
  }
}
