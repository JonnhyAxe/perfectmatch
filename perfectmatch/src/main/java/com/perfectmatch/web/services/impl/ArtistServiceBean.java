package com.perfectmatch.web.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.ArtistRepository;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.exception.MyPreconditionFailedException;
import com.perfectmatch.web.services.ArtistService;

@Service
public class ArtistServiceBean extends AbstractRawService<Artist> implements ArtistService {

  @Autowired private ArtistRepository dao;

  @Override
  public Artist createArtist(String name, List<String> websites) {

    Artist newArtist = new Artist();
    newArtist.setName(name);
    newArtist.getWebsites().addAll(websites);

    return this.createArtist(newArtist);
  }

  @Override
  public Artist createArtist(Artist artist) {
    Artist artistByName = getDao().findByName(artist.getName());
    if (Objects.isNull(artistByName)) {
      return create(artist);
    }
    throw new MyPreconditionFailedException("Artist Name " + artist.getName() + " already exists");
  }

  /**
   * @return the ArtistRepository
   */
  @Override
  public ArtistRepository getDao() {
    return dao;
  }

  @Override
  public Artist getArtistById(String id) {
    return this.getDao().findById(id).orElseGet(null);
  }

  @Override
  public Artist getArtistByName(String name) {
    return this.getDao().findByName(name);
  }

  @Override
  public Artist deleteArtistByName(String name) {
    Artist artist = getArtistByName(name);
    if (Objects.nonNull(artist)) { //TODO: remove artist only if not content/musics
      delete(artist.getId());
      return artist;
    }
    throw new MyPreconditionFailedException("Artist Name " + artist.getName() + " does not exists");
  }
}
