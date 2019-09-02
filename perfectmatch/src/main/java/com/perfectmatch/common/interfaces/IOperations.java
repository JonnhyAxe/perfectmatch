package com.perfectmatch.common.interfaces;

import java.io.Serializable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IOperations<T extends Serializable> {

  // find - one

  Mono<T> findOne(final String id);

  /**
   * if nothing is found, an empty list will be returned to the calling client <br>
   */
  Flux<T> findAll();

  // create

  Mono<T> create(final T resource);

  // update

  Mono<T> update(final T resource);

  // delete

  void delete(final String id);

  void deleteAll();

  // count

  Mono<Long> count();
}
