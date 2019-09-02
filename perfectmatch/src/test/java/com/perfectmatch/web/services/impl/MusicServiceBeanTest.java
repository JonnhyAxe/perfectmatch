package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(MockitoJUnitRunner.class)
public class MusicServiceBeanTest {

  @Mock
  MusicRepository dao;

  @Mock
  ArtistRepository artistDao;

  @InjectMocks
  MusicServiceBean musicService;

  @Test
  public void testFindAll() {
    // Given
    Music onlyThis = new Music();
    Flux<Music> expectedMusics = Flux.just(new Music());
    when(dao.findAll()).thenReturn(expectedMusics);

    // When
    Flux<Music> fluxOfMusics = musicService.findAll();
    List<Music> actualMusics = fluxOfMusics.collectList().block();


    // Then
    assertThat(actualMusics).isNotNull().isNotEmpty().contains(onlyThis);
  }

  @Test
  public void testSaveMusicWithoutName() {
    // Given
    Music expectedMusic = new Music();

    // When
    assertThrows(MyPreconditionFailedException.class, () -> {
      musicService.save(expectedMusic);
    });

  }

  @Test
  public void testSaveMusicWithoutStyle() {
    // Given
    Music expectedMusic = new Music();
    expectedMusic.setName("MyMusicName");
    // When


    assertThrows(MyPreconditionFailedException.class, () -> {
      musicService.save(expectedMusic);
    });

    // Then
  }

  @Test
  public void testSaveMusicWithoutValidStyle() {
    // Given
    Music expectedMusic = new Music();
    expectedMusic.setName("MyMusicName");
    expectedMusic.setStyle("MyMusicName");
    // When

    assertThrows(MyPreconditionFailedException.class, () -> {
      musicService.save(expectedMusic);
    });
    // Then
  }

  @Test
  public void testSaveMusicWithoutArtistName() {
    // Given
    Music expectedMusic = new Music();
    expectedMusic.setName("MyMusicName");
    expectedMusic.setStyle(Style.TECH_HOUSE.name());

    // When
    assertThrows(MyPreconditionFailedException.class, () -> {
      musicService.save(expectedMusic);
    });


    // Then
  }

  @Test
  public void testSaveMusicWithoutArtistCreated() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    Music expectedMusic = new Music();
    expectedMusic.setArtists(Arrays.asList(artistName));
    expectedMusic.setName("MyMusicName");
    expectedMusic.setStyle(Style.TECH_HOUSE.name());

    Mockito.when(artistDao.findByName(artistName)).thenReturn(null);

    // When
    assertThrows(MyPreconditionFailedException.class, () -> {
      musicService.save(expectedMusic);
    });


    // Then
  }

  @Test
  public void testSavedMusic() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    String musicId = "AwesomeId";
    Music expectedMusic = new Music();
    expectedMusic.setId(musicId);
    String musicName = "MyMusicName";
    expectedMusic.setArtists(Arrays.asList(artist.getName()));
    expectedMusic.setName(musicName);
    expectedMusic.setKey("updatKey");
    expectedMusic.setTempo("UpdateTempo");
    expectedMusic.setRecordLabel("UpdateRecordeLabel");
    expectedMusic.setEnergy("UpdateEnergy");
    expectedMusic.setStyle(Style.HOUSE.name());

    Mockito.when(dao.findByName(musicName)).thenReturn(Mono.empty());
    Mockito.when(dao.findById(musicId)).thenReturn(Mono.just(expectedMusic));

    Mockito.when(artistDao.findByName(artist.getName())).thenReturn(Mono.just(artist));

    ArgumentCaptor<Music> argument = ArgumentCaptor.forClass(Music.class);
    Mockito.when(dao.save(argument.capture())).thenReturn(Mono.just(expectedMusic));

    // When
    Music actualMusic = musicService.save(expectedMusic).block();

    // Then
    assertThat(actualMusic).isNotNull().isEqualTo(expectedMusic);
  }


  @Test
  public void testSavedMusicWithStepVerifier() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    Music expectedMusic = new Music();
    String musicName = "MyMusicName";
    expectedMusic.setArtists(Arrays.asList(artistName));
    expectedMusic.setName(musicName);
    expectedMusic.setStyle(Style.TECH_HOUSE.name());

    Mockito.when(artistDao.findByName(expectedMusic.getArtist())).thenReturn(Mono.just(artist));
    Mockito.when(dao.findByName(musicName)).thenReturn(Mono.just(expectedMusic));
    Mockito.when(dao.save(expectedMusic)).thenReturn(Mono.just(expectedMusic));

    // When, Then
    StepVerifier.create(musicService.save(expectedMusic)).assertNext(actualMusic -> {
      assertThat(actualMusic).isNotNull().isEqualTo(expectedMusic);

    }).expectComplete().verify();

  }

  @Test
  public void testSaveMusic() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    Music expectedMusic = new Music();
    String musicName = "MyMusicName";
    expectedMusic.setArtists(Arrays.asList(artistName));
    expectedMusic.setName(musicName);
    expectedMusic.setStyle(Style.TECH_HOUSE.name());

    Mockito.when(artistDao.findByName(artistName)).thenReturn(Mono.just(artist));
    Mockito.when(dao.findByName(musicName)).thenReturn(Mono.empty());
    Mockito.when(dao.save(expectedMusic)).thenReturn(Mono.just(expectedMusic));


    // When
    Music actualMusic = musicService.save(expectedMusic).block();

    // Then
    assertThat(actualMusic).isNotNull().isEqualTo(expectedMusic);
    // Mockito.verify(artistDao.findByName(Mockito.anyString()), Mockito.times(1));
    // Mockito.verify(dao.findByName(Mockito.anyString()), Mockito.times(1));
    // Mockito.verify(dao.save(Mockito.any(Music.class)), Mockito.times(1));

  }


  @Test
  public void testUpdateMusicArtist() {
    // Given
    String artistName = "AwesomeArtistName";

    Music music = new Music();
    String musicName = "MyMusicName";
    music.setArtists(Arrays.asList(artistName));
    music.setName(musicName);
    music.setStyle(Style.TECH_HOUSE.name());

    // When

    assertThrows(MyBadRequestException.class, () -> {
      musicService.updateMusic(music);
    });
    // Then

  }

  @Test
  public void testUpdateMusicStyle() {
    // Given
    Music music = new Music();
    music.setStyle(Style.TECH_HOUSE.name());

    // When

    assertThrows(MyBadRequestException.class, () -> {
      musicService.updateMusic(music);
    });
    // Then

  }


  @Test
  public void testUpdateMusicNotSaved() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    Music expectedMusic = new Music();
    String musicName = "MyMusicName";
    expectedMusic.setName(musicName);
    expectedMusic.setKey("updatkey");

    Mockito.when(dao.findByName(musicName)).thenReturn(Mono.empty());


    // When
    StepVerifier.create(musicService.updateMusic(expectedMusic)).expectComplete().verify();


  }

  @Test
  public void testUpdateMusicSaved() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    String musicId = "AwesomeId";
    Music persistedMusic = new Music();
    persistedMusic.setId(musicId);
    String musicName = "MyMusicName";
    persistedMusic.setArtists(Arrays.asList(artist.getName()));
    persistedMusic.setName(musicName);
    persistedMusic.setKey("updatKey");
    persistedMusic.setTempo("UpdateTempo");
    persistedMusic.setRecordLabel("UpdateRecordeLabel");
    persistedMusic.setEnergy("UpdateEnergy");
    persistedMusic.setStyle(Style.HOUSE.name());



    Set<String> rmx = new HashSet<String>();
    rmx.add("AwesomeArtistName");
    persistedMusic.setRemixers(rmx);

    Mockito.when(dao.findByName(musicName)).thenReturn(Mono.just(persistedMusic));
    Mockito.when(dao.findById(musicId)).thenReturn(Mono.just(persistedMusic));

    Mockito.when(artistDao.findByName(artist.getName())).thenReturn(Mono.just(artist));


    Music musicToUpdate = new Music();
    musicToUpdate.setId(musicId);
    musicToUpdate.setName(musicName);
    musicToUpdate.setEnergy("newEnergy");
    musicToUpdate.setEnergy("UpdateTempo");

    ArgumentCaptor<Music> argument = ArgumentCaptor.forClass(Music.class);
    Mockito.when(dao.save(argument.capture())).thenReturn(Mono.just(persistedMusic));


    // When
    Music actualMusic = musicService.updateMusic(musicToUpdate).block();

    // Then
    assertThat(actualMusic).isNotNull().isEqualTo(persistedMusic);

  }

  @Test
  public void testUpdateMusicRemixers() {
    // Given
    String artistName = "AwesomeArtistName";
    Artist artist = new Artist();
    artist.setName(artistName);

    String musicId = "AwesomeId";
    Music persistedMusic = new Music();
    persistedMusic.setId(musicId);
    String musicName = "MyMusicName";
    persistedMusic.setArtists(Arrays.asList(artist.getName()));
    persistedMusic.setName(musicName);
    persistedMusic.setKey("updatKey");
    persistedMusic.setTempo("UpdateTempo");
    persistedMusic.setRecordLabel("UpdateRecordeLabel");
    persistedMusic.setEnergy("UpdateEnergy");
    persistedMusic.setStyle(Style.HOUSE.name());

    Mockito.when(dao.findByName(musicName)).thenReturn(Mono.just(persistedMusic));
    Mockito.when(dao.findById(musicId)).thenReturn(Mono.just(new Music()));

    Mockito.when(artistDao.findByName(artist.getName())).thenReturn(Mono.just(artist));

    Music musicToUpdate = new Music();
    musicToUpdate.setId(musicId);
    musicToUpdate.setName(musicName);

    Set<String> rmx = new HashSet<String>();
    rmx.add("AwesomeArtistName");
    musicToUpdate.setRemixers(rmx);

    ArgumentCaptor<Music> argument = ArgumentCaptor.forClass(Music.class);
    Mockito.when(dao.save(argument.capture())).thenReturn(Mono.just(persistedMusic));


    // When
    Music actualMusic = musicService.updateMusic(musicToUpdate).block();

    // Then
    assertThat(actualMusic).isNotNull().isEqualTo(persistedMusic);

  }



}
