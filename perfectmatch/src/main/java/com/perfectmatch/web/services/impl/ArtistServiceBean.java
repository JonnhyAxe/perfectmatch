package com.perfectmatch.web.services.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.ArtistRepository;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.exception.ArtistDeleteException;
import com.perfectmatch.web.exception.MyPreconditionFailedException;
import com.perfectmatch.web.services.ArtistService;
import reactor.core.publisher.Mono;

@Service
public class ArtistServiceBean extends AbstractRawService<Artist> implements ArtistService {

  @Autowired
  private ArtistRepository dao;

  @Autowired
  private MusicRepository musicDao;

  @Override
  public Mono<Artist> createArtist(String name, List<String> websites) {
    return this.createArtist(Artist.builder().name(name).websites(websites).build());
  }

  @Override
  public Mono<Artist> createArtist(Artist artist) {
    return getDao().findByName(artist.getName()).switchIfEmpty(create(artist));
  }

  /**
   * @return the ArtistRepository
   */
  @Override
  public ArtistRepository getDao() {
    return dao;
  }

  @Override
  public Mono<Artist> getArtistById(String id) {
    return this.getDao().findById(id).switchIfEmpty(Mono.defer(() -> Mono
        .error(() -> new MyPreconditionFailedException("No Artist found with id " + id))));
  }

  @Override
  public Mono<Artist> getArtistByName(String name) {
    return this.getDao().findByName(name);
  }

  @Override
  public Mono<Artist> deleteArtistByName(String name) {

    return getArtistByName(name)
        .switchIfEmpty(Mono.error(new ArtistDeleteException("Cannot remove artist with musics")))
        .filter(artist -> !containsMusics(artist.getName()))
        .switchIfEmpty(Mono.error(new ArtistDeleteException("Cannot remove artist with musics")))
        .flatMap(artist -> {
          delete(artist.getId());
          return Mono.just(artist);
        });
  }

  private boolean containsMusics(String name) {
    return musicDao.findByArtist(name).isEmpty();
  }
}
