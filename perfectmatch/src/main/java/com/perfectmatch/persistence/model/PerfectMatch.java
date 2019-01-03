package com.perfectmatch.persistence.model;

import java.io.Serializable;
import java.net.URL;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.model.NameableEntity;
import com.perfectmatch.persistence.model.Sample.SampleBuilder;

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
@ApiModel(description = "Details of the match - second step process envolving music samples")
public class PerfectMatch implements NameableEntity, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -9166396470466850949L;

  @ApiModelProperty(notes = "Id Match")
  @Id private String id;

  @NotNull
  @ApiModelProperty(notes = "Name of Match")
  private String name;

 
}
