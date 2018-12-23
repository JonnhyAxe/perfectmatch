package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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
import com.perfectmatch.persistence.model.Style;
import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyPreconditionFailedException;

@RunWith(MockitoJUnitRunner.class)
public class MusicServiceBeanTest {

	@Mock MusicRepository dao;

	@Mock ArtistRepository artistDao;

	@InjectMocks MusicServiceBean musicService;
	
	@Test
	public void testFindAll() {
		//Given 
		List<Music> expectedMusics = Arrays.asList(new Music());
		when(dao.findAll()).thenReturn(expectedMusics);
		
		//When
		List<Music> actualMusics  = musicService.findAll();
		
		//Then
		assertThat(actualMusics).isNotNull().isNotEmpty().isEqualTo(expectedMusics);
	}
	
	@Test(expected = MyPreconditionFailedException.class)
	public void testSaveMusicWithoutName() {
		//Given 
		Music expectedMusic = new Music();
		
		//When
		musicService.save(expectedMusic);
		
		//Then
	}	
	
	@Test(expected = MyPreconditionFailedException.class)
	public void testSaveMusicWithoutStyle() {
		//Given 
		Music expectedMusic = new Music();
		expectedMusic.setName("MyMusicName");
		//When
		musicService.save(expectedMusic);
		
		//Then
	}
	
	@Test(expected = MyPreconditionFailedException.class)
	public void testSaveMusicWithoutValidStyle() {
		//Given 
		Music expectedMusic = new Music();
		expectedMusic.setName("MyMusicName");
		expectedMusic.setStyle("MyMusicName");
		//When
		musicService.save(expectedMusic);
		
		//Then
	}
	
	@Test(expected = MyPreconditionFailedException.class)
	public void testSaveMusicWithoutArtistName() {
		//Given 
		Music expectedMusic = new Music();
		expectedMusic.setName("MyMusicName");
		expectedMusic.setStyle(Style.TECH_HOUSE.name());
		
		//When
		musicService.save(expectedMusic);
		
		//Then
	}
	
	@Test(expected = MyPreconditionFailedException.class)
	public void testSaveMusicWithoutArtistCreated() {
		//Given
		String artistName = "AwesomeArtistName";
		Artist artist = new Artist();
		artist.setName(artistName);
		
		Music expectedMusic = new Music();
		expectedMusic.setArtists(Arrays.asList(artistName));
		expectedMusic.setName("MyMusicName");
		expectedMusic.setStyle(Style.TECH_HOUSE.name());
		
		Mockito.when(artistDao.findByName(artistName)).thenReturn(null);

		//When
		musicService.save(expectedMusic);
		
		//Then
	}
	
	@Test
	public void testSavedMusic() {
		//Given
		String artistName = "AwesomeArtistName";
		Artist artist = new Artist();
		artist.setName(artistName);
		
		Music expectedMusic = new Music();
		String musicName = "MyMusicName";
		expectedMusic.setArtists(Arrays.asList(artistName));
		expectedMusic.setName(musicName);
		expectedMusic.setStyle(Style.TECH_HOUSE.name());
		
		Mockito.when(artistDao.findByName(artistName)).thenReturn(artist);
		Mockito.when(dao.save(expectedMusic)).thenReturn(expectedMusic);

		
		//When
		Music actualMusic = musicService.save(expectedMusic);
		
		//Then
		assertThat(actualMusic).isNotNull().isEqualTo(expectedMusic);
	}
	
	@Test
	public void testSaveMusic() {
		//Given
		String artistName = "AwesomeArtistName";
		Artist artist = new Artist();
		artist.setName(artistName);
		
		Music expectedMusic = new Music();
		String musicName = "MyMusicName";
		expectedMusic.setArtists(Arrays.asList(artistName));
		expectedMusic.setName(musicName);
		expectedMusic.setStyle(Style.TECH_HOUSE.name());
		
		Mockito.when(artistDao.findByName(artistName)).thenReturn(artist);
		Mockito.when(dao.findByName(musicName)).thenReturn(null);
		Mockito.when(dao.save(expectedMusic)).thenReturn(expectedMusic);

		
		//When
		Music actualMusic = musicService.save(expectedMusic);
		
		//Then
		assertThat(actualMusic).isNotNull().isEqualTo(expectedMusic);
//		Mockito.verify(artistDao.findByName(Mockito.anyString()), Mockito.times(1));
//		Mockito.verify(dao.findByName(Mockito.anyString()), Mockito.times(1));
//		Mockito.verify(dao.save(Mockito.any(Music.class)), Mockito.times(1));

	}
	
	
	@Test(expected = MyBadRequestException.class)
	public void testUpdateMusicArtist() {
		//Given
		String artistName = "AwesomeArtistName";
	
		Music music = new Music();
		String musicName = "MyMusicName";
		music.setArtists(Arrays.asList(artistName));
		music.setName(musicName);
		music.setStyle(Style.TECH_HOUSE.name());

		//When
		 musicService.updateMusic(music);
		
		//Then

	}
	
	@Test(expected = MyBadRequestException.class)
	public void testUpdateMusicStyle() {
		//Given
		Music music = new Music();
		music.setStyle(Style.TECH_HOUSE.name());

		//When
		musicService.updateMusic(music);
		
		//Then

	}
	
	@Test(expected = MyBadRequestException.class)
	public void testUpdateMusicName() {
		//Given
		Music music = new Music();
		music.setName("AwesomeMusicName");

		//When
		musicService.updateMusic(music);
		
		//Then

	}
}
