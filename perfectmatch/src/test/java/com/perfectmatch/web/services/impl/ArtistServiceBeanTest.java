package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class ArtistServiceBeanTest {

  @Mock
  private ArtistRepository dao;
  @Mock
  private MusicRepository musicDao;

  @InjectMocks
  ArtistServiceBean artistService;

  @Test
  public void createArtistByName() {
    // Given
    String artistName = "AwesomeArtistName";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setName(artistName);
    expectedArtist.setWebsites(website);

    Mockito.when(dao.findByName(expectedArtist.getName())).thenReturn(Mono.empty());
    Mockito.when(dao.save(expectedArtist)).thenReturn(Mono.just(expectedArtist));

    // When
    Mono<Artist> actualMonoArtist = artistService.createArtist(artistName, website);
    Artist actualArtist = actualMonoArtist.block();
    // Then
    assertThat(actualArtist).isNotNull();
    assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
    assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
    assertThat(actualArtist).isEqualTo(expectedArtist);
  }

  @Test
  public void createArtistByNameAlreadyCreated() {
    // Given
    String artistName = "AwesomeArtistName";
    String artistId = "ArtistName";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setName(artistName);
    expectedArtist.setId(artistId);
    expectedArtist.setWebsites(website);

    Mockito.when(dao.findByName(artistName)).thenReturn(Mono.just(expectedArtist));
    Mockito.when(dao.findById(artistId)).thenReturn(Mono.just(expectedArtist));

    // When
    Artist actualArtist = artistService.createArtist(artistName, website).block();

    // Then
    assertThat(actualArtist).isNotNull();
    assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
    assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
    assertThat(actualArtist).isEqualTo(expectedArtist);

  }


  @Test
  public void createArtist() {
    // Given
    String artistName = "AwesomeArtistName";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setName(artistName);
    expectedArtist.setWebsites(website);

    Mockito.when(dao.findByName(expectedArtist.getName())).thenReturn(Mono.empty());
    Mockito.when(dao.save(expectedArtist)).thenReturn(Mono.just(expectedArtist));

    // When
    Artist actualArtist = artistService.createArtist(expectedArtist).block();

    // Then
    assertThat(actualArtist).isNotNull();
    assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
    assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
    assertThat(actualArtist).isEqualTo(expectedArtist);
  }

  // @Test(expected = MyPreconditionFailedException.class)
  @Test
  public void createArtistAlreadyExisted() {
    // Given
    String artistName = "AwesomeArtistName";
    String artistId = "artistId";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setName(artistName);
    expectedArtist.setId(artistId);
    expectedArtist.setWebsites(website);

    Mockito.when(dao.findById(artistId)).thenReturn(Mono.just(expectedArtist));

    // When

    assertThrows(MyPreconditionFailedException.class, () -> {
      artistService.createArtist(expectedArtist).block();
    });

  }

  @Test
  public void getArtistByName() {
    // Given
    String artistName = "AwesomeArtistName";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setName(artistName);
    expectedArtist.setWebsites(website);


    Mockito.when(dao.findByName(artistName)).thenReturn(Mono.just(expectedArtist));

    // When
    Artist actualArtist = artistService.getArtistByName(artistName).block();

    // Then
    assertThat(actualArtist).isNotNull();
    assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
    assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
    assertThat(actualArtist).isEqualTo(expectedArtist);
  }

  @Test
  public void getArtistById() {
    // Given
    String artistName = "AwesomeArtistName";
    String artistId = "AwesomeArtistID";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setName(artistName);
    expectedArtist.setWebsites(website);

    Mockito.when(dao.findById(artistId)).thenReturn(Mono.just(expectedArtist));

    // When
    Artist actualArtist = artistService.getArtistById(artistId).block();

    // Then
    assertThat(actualArtist).isNotNull();
    assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
    assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
    assertThat(actualArtist).isEqualTo(expectedArtist);
  }

  @Test
  public void getUnexistingArtistById() {
    // Given
    String artistId = "AwesomeArtistName";


    Mockito.when(dao.findById(artistId)).thenReturn(Mono.empty());

    // When

    assertThrows(MyPreconditionFailedException.class, () -> {
      artistService.getArtistById(artistId).block();
    });

    // Then
  }

  @Test
  public void deleteArtistByName() {
    // Given
    String artistName = "AwesomeArtistName";
    String artistId = "AwesomeArtistID";
    List<String> website = new ArrayList<>();
    website.add("http://www.aswesome-artist-website.com");

    Artist expectedArtist = new Artist();
    expectedArtist.setId(artistId);
    expectedArtist.setName(artistName);
    expectedArtist.setWebsites(website);

    Mockito.when(dao.findByName(artistName)).thenReturn(Mono.just(expectedArtist));
    Mockito.when(dao.findById(artistId)).thenReturn(Mono.just(expectedArtist));
    Set<Music> musics = new HashSet<Music>();
    musics.add(new Music());
    Mockito.when(musicDao.findByArtist(artistName)).thenReturn(musics);



    // When
    Artist actualArtist = artistService.deleteArtistByName(artistName).block();

    // Then
    assertThat(actualArtist).isNotNull();
    assertThat(actualArtist.getName()).isNotNull().isEqualTo(artistName);
    assertThat(actualArtist.getWebsites()).isNotNull().isNotEmpty().isEqualTo(website);
    assertThat(actualArtist).isEqualTo(expectedArtist);
  }
}
