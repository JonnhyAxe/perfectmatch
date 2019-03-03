package com.perfectmatch.persistence.model;

import java.io.Serializable;
import java.net.URL;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * Represents an match between two samples
 *
 */
@Data(staticConstructor="of")
@ToString(includeFieldNames=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
