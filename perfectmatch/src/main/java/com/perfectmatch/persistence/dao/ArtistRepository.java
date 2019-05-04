package com.perfectmatch.persistence.dao;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Artist;

public interface ArtistRepository
    extends ReactiveCrudRepository<Artist, String>, ByNameSearchable<Artist> {
}
