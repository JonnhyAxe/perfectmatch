package com.perfectmatch.persistence.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor 
@ApiModel(description = "All details about the artist ")
public class Artist implements NameableEntity {

  /**
   *
   */
  private static final long serialVersionUID = -5955358399261452115L;

  @Id private String id;

  @NotNull
  @ApiModelProperty(notes = "Name of the artist - without format contrains")
  private String name;

  @ApiModelProperty(notes = "Websites of the artist - without format contrains")
  private List<String> websites = new ArrayList<>();

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name);
  }

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
    Artist other = (Artist) obj;

    return Objects.equals(id, other.id) && Objects.equals(name, other.name);
  }
}
