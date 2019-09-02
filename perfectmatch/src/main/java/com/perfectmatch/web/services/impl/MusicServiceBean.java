package com.perfectmatch.web.services.impl;

import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.ArtistRepository;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.persistence.model.Style;
import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyPreconditionFailedException;
import com.perfectmatch.web.services.MusicService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Expose web services for Music Entity
 *
 */
@Service
public class MusicServiceBean extends AbstractRawService<Music> implements MusicService {

  @Autowired
  private MusicRepository dao;

  @Autowired
  private ArtistRepository artistDao;

  /**
   * @return the MusicRepository
   */
  @Override
  public MusicRepository getDao() {

    return dao;
  }

  @Override
  public Flux<Music> findAll() {

    return getDao().findAll();
  }

  @Override
  public Mono<Music> findByName(final String name) {

    return getDao().findByName(name);
  }

  @Override
  public Set<Music> findByArtist(final String name) {

    return getDao().findByArtist(name);
  }

  @Override
  public Mono<Music> save(Music music) {
    //
    musicSavePreconditions(music);

    return findByName(music.getName()).switchIfEmpty(create(music));
  }


  @Override
  public Mono<Music> updateMusic(Music music) {

    musicUpdatePreconditons(music);
    return findByName(music.getName())
        // musicToUpdate.switchIfEmpty(Mono.empty())
        .flatMap(musicToUpdate2 -> merge(musicToUpdate2, music))
        .flatMap(musicToUpdate2 -> update(musicToUpdate2));

  }

  public Mono<Music> merge(Music musicDB, Music music) {
    // find merge method as Hibernate merge

    addRemixers(musicDB, music);
    if (Objects.nonNull(music.getRecordLabel())) {
      musicDB.setRecordLabel(music.getRecordLabel());
    }
    if (Objects.nonNull(music.getTempo())) {
      musicDB.setTempo(music.getTempo());
    }
    if (Objects.nonNull(music.getKey())) {
      musicDB.setKey(music.getKey());
    }
    if (Objects.nonNull(music.getEnergy())) {
      musicDB.setEnergy(music.getEnergy());
    }
    return Mono.just(musicDB);

  }

  private void addRemixers(Music musicToUpdate, Music music) {
    Set<String> remixers = musicToUpdate.getRemixers();
    Set<String> remixersToAdd = music.getRemixers();
    remixersToAdd.stream().forEach(remixers::add);
  }

  private void musicUpdatePreconditons(Music music) {

    if (Objects.nonNull(music.getArtists()) || Objects.nonNull(music.getStyle())) {
      throw new MyBadRequestException("Some fields connot be updated");
    }
  }

  // TODO: add this to an helper class
  private void musicSavePreconditions(Music music) {
    if (Objects.isNull(music.getName())) {
      throw new MyPreconditionFailedException("Music name is mandatory to create musics");
    }
    if (Objects.isNull(music.getStyle())) {
      throw new MyPreconditionFailedException("Music style is mandatory to create musics");
    }
    try {
      Style.valueOf(music.getStyle());
    } catch (IllegalArgumentException ex) {
      throw new MyPreconditionFailedException("Music style not found");
    }

    if (Objects.isNull(music.getArtist())) {
      throw new MyPreconditionFailedException("Artist id is mandatory to create musics");
    }
    if (Objects.isNull(artistDao.findByName(music.getArtist()))) {
      throw new MyPreconditionFailedException("Artist Name " + music.getArtist() + " not found");
    }
  }
}
