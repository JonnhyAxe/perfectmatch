package com.perfectmatch.web.services;

import com.perfectmatch.common.interfaces.IOperations;
import com.perfectmatch.common.services.PersistenceService;
import com.perfectmatch.persistence.model.Match;
import reactor.core.publisher.Mono;

/**
 * This class aims to expose Match (between Samples) related services for Web Controllers
 *
 */
public interface SampleMatchService extends PersistenceService<Match>, IOperations<Match> {

  boolean contains(Match newMatch);

  Mono<Match> findMatchByName(String name);
}
