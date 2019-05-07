package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.MatchRule;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class SampleMatchServiceBeanTest {

  @Mock
  SampleMatchRepository dao;

  @InjectMocks
  SampleMatchServiceBean sampleMatchService;


  @Test
  public void findMatchByName() {
    // Given
    String musicNameThis = "MusicNameThis";
    String musicNameThat = "MusicNameThat";

    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThat(musicNameThat);
    expectedMatch.setMusicNameThis(musicNameThis);
    expectedMatch.setMusicNameThat(MatchRule.DEFAULT.name());

    Mockito.when(dao.findMatchByMusics(Mockito.anyString(), Mockito.anyString()))
        .thenReturn(Mono.just(expectedMatch));

    // When
    Match actualMatch =
        sampleMatchService.findMatchByName(musicNameThis + "," + musicNameThat).block();

    // Then
    assertThat(actualMatch).isNotNull();
    assertThat(actualMatch).isEqualTo(expectedMatch);

  }

  @Test
  public void containsByMusicThat() {
    // Given
    String musicNameThis = "MusicNameThis";
    String musicNameThat = "MusicNameThat";

    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThat(musicNameThat);
    expectedMatch.setMusicNameThis(musicNameThis);
    expectedMatch.setMusicNameThat(MatchRule.DEFAULT.name());

    Mockito.when(dao.findAllBymusicName(musicNameThis)).thenReturn(Flux.just(expectedMatch));
    // When
    Boolean containsMatchWithOneOfTheSamples = sampleMatchService.contains(expectedMatch);

    // Then
    assertThat(containsMatchWithOneOfTheSamples).isNotNull().isTrue();

  }


  @Test
  public void containsByMusicThis() {
    // Given
    String musicNameThis = "MusicNameThis";
    String musicNameThat = "MusicNameThat";


    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThat(musicNameThat);
    expectedMatch.setMusicNameThis(musicNameThis);
    expectedMatch.setMusicNameThat(MatchRule.DEFAULT.name());

    Mockito.when(dao.findAllBymusicName(expectedMatch.getMusicNameThis()))
        .thenReturn(Flux.just(expectedMatch));

    // When
    Boolean containsMatchWithOneOfTheSamples = sampleMatchService.contains(expectedMatch);

    // Then
    assertThat(containsMatchWithOneOfTheSamples).isNotNull().isTrue();

  }
}
