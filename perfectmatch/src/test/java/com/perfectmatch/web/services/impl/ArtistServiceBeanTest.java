package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.perfectmatch.persistence.dao.ArtistRepository;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.exception.MyPreconditionFailedException;

@RunWith(MockitoJUnitRunner.class)
public class ArtistServiceBeanTest {

  @Mock private ArtistRepository dao;
  @Mock private MusicRepository musicDao;
  
  @InjectMocks ArtistServiceBean artistService;

  @Test
  public void createArtistByName() {
    //Given
	String artistName = "AwesomeArtistName";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);
		
	Mockito.when(dao.save(expectedArtist)).thenReturn(expectedArtist);

	//When
	Artist actualArtist = artistService.createArtist(artistName, website); 
	
	//Then
	assertThat(actualArtist).isNotNull();
	assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
	assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
	assertThat(actualArtist).isEqualTo(expectedArtist);
  }
  
  @Test
  public void createArtistByNameAlreadyCreated() {
    //Given
	String artistName = "AwesomeArtistName";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);

	Mockito.when(dao.findByName(artistName)).thenReturn(expectedArtist);
	
	//When
	
	assertThrows(MyPreconditionFailedException.class, () -> {
		artistService.createArtist(artistName, website); 
	 });
	
	
	//Then
  }
  
  
  @Test
  public void createArtist() {
    //Given
	String artistName = "AwesomeArtistName";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);
	
	Mockito.when(dao.save(expectedArtist)).thenReturn(expectedArtist);
	
	//When
	Artist actualArtist = artistService.createArtist(expectedArtist); 
	
	//Then
	assertThat(actualArtist).isNotNull();
	assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
	assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
	assertThat(actualArtist).isEqualTo(expectedArtist);
  }
  
//  @Test(expected = MyPreconditionFailedException.class)
  @Test
  public void createArtistAlreadyExisted() {
    //Given
	String artistName = "AwesomeArtistName";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);
	
	Mockito.when(dao.findByName(artistName)).thenReturn(expectedArtist);
	
	//When
	
	assertThrows(MyPreconditionFailedException.class, () -> {
		Artist actualArtist = artistService.createArtist(expectedArtist); 
	 });

  }
  
  @Test
  public void getArtistByName() {
    //Given
	String artistName = "AwesomeArtistName";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);

	
	Mockito.when(dao.findByName(artistName)).thenReturn(expectedArtist);
	
	//When
	Artist actualArtist = artistService.getArtistByName(artistName); 
	
	//Then
	assertThat(actualArtist).isNotNull();
	assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
	assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
	assertThat(actualArtist).isEqualTo(expectedArtist);
  }
  
  @Test
  public void getArtistById() {
    //Given
	String artistName = "AwesomeArtistName";
	String artistId = "AwesomeArtistID";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);
	
	Mockito.when(dao.findById(artistId)).thenReturn(Optional.of(expectedArtist));
	
	//When
	Artist actualArtist = artistService.getArtistById(artistId); 
	
	//Then
	assertThat(actualArtist).isNotNull();
	assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
	assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
	assertThat(actualArtist).isEqualTo(expectedArtist);
  }
  
  @Test
  public void getUnexistingArtistById() {
    //Given
	String artistName = "AwesomeArtistName";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);

	//When
	
	assertThrows(MyPreconditionFailedException.class, () -> {
		artistService.getArtistById(artistName); 
	 });
	
	//Then
 }
  
  @Test
  public void deleteArtistByName() {
    //Given
	String artistName = "AwesomeArtistName";
	String artistId = "AwesomeArtistID";
	List<String> website = new ArrayList<>();
	website.add("http://www.aswesome-artist-website.com");
	
	Artist expectedArtist = new Artist();
	expectedArtist.setId(artistId);
	expectedArtist.setName(artistName);
	expectedArtist.setWebsites(website);
	
	Mockito.when(dao.findByName(artistName)).thenReturn(expectedArtist);
	Mockito.when(dao.findById(artistId)).thenReturn(Optional.of(expectedArtist));
	Set<Music> musics = new HashSet<Music>();
	musics.add(new Music());
	Mockito.when(musicDao.findByArtist(artistName)).thenReturn(musics);
	
	
	
	//When
	Artist actualArtist = artistService.deleteArtistByName(artistName); 
	
	//Then
	assertThat(actualArtist).isNotNull();
	assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
	assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
	assertThat(actualArtist).isEqualTo(expectedArtist);
 }
}
