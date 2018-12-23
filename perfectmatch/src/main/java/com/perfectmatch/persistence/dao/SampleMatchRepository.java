package com.perfectmatch.persistence.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.PerfectMatch;

public interface SampleMatchRepository
    extends MongoRepository<Match, String>, ByNameSearchable<PerfectMatch> {

  @Query("{'$or' : [{'musicNameThis' : ?0}, {'musicNameThat' : ?0}]}")
  List<Match> findAllBymusicName(String musicNameThis);

  @Query("{'$and' : [{'musicNameThis' : ?0}, {'musicNameThat' : ?1}]}")
  Match findMatchByMusics(String musicNameThis, String musicNameThat);
}
