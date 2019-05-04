package com.perfectmatch.persistence.model;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.util.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.perfectmatch.common.interfaces.ByArtistQueryable;
import com.perfectmatch.common.interfaces.MetaDataQueryable;
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
 *
 * This class represents an Music to sample from
 *
 */
@Data(staticConstructor = "of")
@ToString(includeFieldNames = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "All details about the music ")
public class Music implements NameableEntity, ByArtistQueryable, MetaDataQueryable {

  /**
   *
   */
  private static final long serialVersionUID = -6021901171439734300L;

  @EqualsAndHashCode.Include
  @Id
  private String id;

  @EqualsAndHashCode.Include
  @NotNull
  @ApiModelProperty(notes = "Names of the music artist - without contrains")
  private List<String> artists;

  @EqualsAndHashCode.Include
  @NotNull
  @ApiModelProperty(notes = "Name of the music - without format contrains")
  private String name;

  @EqualsAndHashCode.Include
  @ApiModelProperty(notes = "Style of the music of type Style")
  @NotNull
  private String style; // grouping

  @Builder.Default
  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "Samples of the music - at least one sample")
  private Set<Sample> samples = new HashSet<>();

  @Builder.Default
  @EqualsAndHashCode.Include
  @ApiModelProperty(notes = "Names of the remixers artist - without contrains")
  private Set<String> remixers = new HashSet<>();

  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "Record Label name")
  private String recordLabel;

  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "key of the music")
  @NotNull
  private String key;

  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "Energy of the music")
  @NotNull
  private String energy; // grouping

  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "Tempo of the music")
  @NotNull
  private String tempo;

  @EqualsAndHashCode.Exclude
  @ApiModelProperty(notes = "Location of the file in the storage")
  @NotNull
  private URL location;


  /**
   * @return the artists
   */
  @Override
  @JsonIgnore
  public String getArtist() {
    return Objects.nonNull(getArtists()) && !getArtists().isEmpty() ? getArtistsNames() : null;
  }

  private String getArtistsNames() {
    return StringUtils.collectionToDelimitedString(artists, ",");
  }
}
