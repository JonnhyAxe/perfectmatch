package com.perfectmatch.web.services;

import java.util.List;

import com.perfectmatch.persistence.model.Artist;

public interface ArtistService {

  Artist createArtist(String name, List<String> websites);

  Artist createArtist(Artist artist);

  Artist getArtistById(String id);

  Artist getArtistByName(String name);

  Artist deleteArtistByName(String name);
}
