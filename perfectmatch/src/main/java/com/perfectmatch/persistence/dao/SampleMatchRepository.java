package com.perfectmatch.persistence.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.perfectmatch.common.interfaces.ByNameSearchable;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.PerfectMatch;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SampleMatchRepository
    extends ReactiveCrudRepository<Match, String>, ByNameSearchable<PerfectMatch> {

  @Query("{'$or' : [{'musicNameThis' : ?0}, {'musicNameThat' : ?0}]}")
  Flux<Match> findAllBymusicName(String musicNameThis);

  @Query("{'$and' : [{'musicNameThis' : ?0}, {'musicNameThat' : ?1}]}")
  Mono<Match> findMatchByMusics(String musicNameThis, String musicNameThat);
}
