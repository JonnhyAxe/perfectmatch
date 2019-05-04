package com.perfectmatch.web.services;

import com.perfectmatch.common.interfaces.ByArtistSearchable;
import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.common.interfaces.IOperations;
import com.perfectmatch.common.services.PersistenceService;
import com.perfectmatch.persistence.model.Music;
import reactor.core.publisher.Mono;

/**
 * This class aims to expose Music related services for Web Controllers
 *
 */
public interface MusicService extends PersistenceService<Music>, IOperations<Music>,
    ByNameSearchable<Music>, ByArtistSearchable<Music> {

  Mono<Music> save(Music resource);

  Mono<Music> updateMusic(Music resource);
}
