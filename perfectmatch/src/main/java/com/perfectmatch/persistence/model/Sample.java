package com.perfectmatch.persistence.model;

import java.net.URL;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.perfectmatch.common.model.NameableEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * This class represents an Sample of one specific music
 *
 */
@Data(staticConstructor="of")
@ToString(includeFieldNames=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Details of the Sample")
public class Sample implements NameableEntity {

  /**
   *
   */
  private static final long serialVersionUID = -4288830678875960178L;

  @EqualsAndHashCode.Include
  @Id private String id;

  @EqualsAndHashCode.Include
  @NotNull
  @ApiModelProperty(notes = "Name of the music")
  private String name;
  
  @EqualsAndHashCode.Include
  @NotNull
  @ApiModelProperty(notes = "Specific position of the original music")
  private int timestamp;
  
  @EqualsAndHashCode.Exclude
  @NotNull
  @ApiModelProperty(notes = "Location of the file in the storage")
  private URL location;

 
}
