package com.perfectmatch.persistence.model;

import java.util.ArrayList;
import java.util.List;

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

 
@ApiModel(description = "All details about the artist ")
@Data(staticConstructor="of")
@ToString(includeFieldNames=true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Artist implements NameableEntity {

  /**
   *
   */
  private static final long serialVersionUID = -5955358399261452115L;

  @EqualsAndHashCode.Include
  @Id private String id;

  @EqualsAndHashCode.Include
  @NotNull
  @ApiModelProperty(notes = "Name of the artist - without format contrains")
  private String name;

  @Builder.Default
  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "Websites of the artist - without format contrains")
  private List<String> websites = new ArrayList<>();

}
