package com.perfectmatch.persistence.model;

import java.net.URL;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents an Sample of one specific music
 *
 */
@Getter 
@Setter 
@NoArgsConstructor 
@ApiModel(description = "Details of the Sample")
public class Sample implements NameableEntity {

  /**
   *
   */
  private static final long serialVersionUID = -4288830678875960178L;

  @Id private String id;

  @NotNull
  @ApiModelProperty(notes = "Name of the music")
  private String name;

  @NotNull
  @ApiModelProperty(notes = "Specific position of the original music")
  private int timestamp;
  
  @NotNull
  @ApiModelProperty(notes = "Location of the file in the storage")
  private URL location;

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + (id == null ? 0 : id.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
    result = prime * result + timestamp;
    return result;
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
    Sample other = (Sample) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    if (name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!name.equals(other.name)) {
      return false;
    }
    if (timestamp != other.timestamp) {
      return false;
    }
    return true;
  }
}
