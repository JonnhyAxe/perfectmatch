package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.MatchRule;

@RunWith(MockitoJUnitRunner.class)
public class SampleMatchServiceBeanTest {

  @Mock SampleMatchRepository dao;

  @InjectMocks SampleMatchServiceBean sampleMatchService;
  
  
  @Test
  public void findMatchByName() {
    //Given 
	String musicNameThis = "MusicNameThis";
	String musicNameThat = "MusicNameThat";	
	
	Match expectedMatch = new Match();
	expectedMatch.setMusicNameThat(musicNameThat);
	expectedMatch.setMusicNameThis(musicNameThis);
	expectedMatch.setMusicNameThat(MatchRule.DEFAULT.name());
	
	Mockito.when(dao.findMatchByMusics(Mockito.anyString(), Mockito.anyString())).thenReturn(expectedMatch);
	
	//When 
	Match actualMatch = sampleMatchService.findMatchByName(musicNameThis + "," + musicNameThat);
	
	//Then
	assertThat(actualMatch).isNotNull();
	assertThat(actualMatch).isEqualTo(expectedMatch);
 
  }
  
  @Test
  public void containsByMusicThat() {
    //Given 
	String musicNameThis = "MusicNameThis";
	String musicNameThat = "MusicNameThat";	
	
	Match expectedMatch = new Match();
	expectedMatch.setMusicNameThat(musicNameThat);
	expectedMatch.setMusicNameThis(musicNameThis);
	expectedMatch.setMusicNameThat(MatchRule.DEFAULT.name());
	

	//When 
	Boolean containsMatchWithOneOfTheSamples = sampleMatchService.contains(expectedMatch);
	
	//Then
	assertThat(containsMatchWithOneOfTheSamples).isNotNull().isTrue();
 
  }
  
  
  @Test
  public void containsByMusicThis() {
    //Given 
	String musicNameThis = "MusicNameThis";
	String musicNameThat = "MusicNameThat";	

	
	Match expectedMatch = new Match();
	expectedMatch.setMusicNameThat(musicNameThat);
	expectedMatch.setMusicNameThis(musicNameThis);
	expectedMatch.setMusicNameThat(MatchRule.DEFAULT.name());
	
	List<Match> matchs = Arrays.asList(expectedMatch);
	
	Mockito.when(dao.findAllBymusicName(expectedMatch.getMusicNameThis())).thenReturn(matchs);
	
	//When 
	Boolean containsMatchWithOneOfTheSamples = sampleMatchService.contains(expectedMatch);
	
	//Then
	assertThat(containsMatchWithOneOfTheSamples).isNotNull().isTrue();
 
  }
}
