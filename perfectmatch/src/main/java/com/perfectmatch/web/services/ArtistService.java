package com.perfectmatch.web.services;

import java.util.List;
import com.perfectmatch.persistence.model.Artist;
import reactor.core.publisher.Mono;

public interface ArtistService {

  Mono<Artist> createArtist(String name, List<String> websites);

  Mono<Artist> createArtist(Artist artist);

  Mono<Artist> getArtistById(String id);

  Mono<Artist> getArtistByName(String name);

  Mono<Artist> deleteArtistByName(String name);
}
