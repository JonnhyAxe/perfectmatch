package com.perfectmatch.persistence.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Artist;

public interface ArtistRepository extends MongoRepository<Artist, String>, ByNameSearchable<Artist> {

}
