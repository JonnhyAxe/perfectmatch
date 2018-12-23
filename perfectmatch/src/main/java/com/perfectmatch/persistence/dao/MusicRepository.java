package com.perfectmatch.persistence.dao;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.perfectmatch.common.interfaces.ByArtistSearchable;
import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Music;

public interface MusicRepository
    extends MongoRepository<Music, String>, ByNameSearchable<Music>, ByArtistSearchable<Music> {}
