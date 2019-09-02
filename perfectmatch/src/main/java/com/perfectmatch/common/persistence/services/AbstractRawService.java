package com.perfectmatch.common.persistence.services;

import java.util.Objects;
import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.perfectmatch.common.ServicePreconditions;
import com.perfectmatch.common.interfaces.IOperations;
import com.perfectmatch.common.model.NameableEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Transactional
public abstract class AbstractRawService<T extends NameableEntity> implements IOperations<T> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public AbstractRawService() {
    super();
  }

  // API
  @Override
  @Transactional(readOnly = true)
  public Mono<T> findOne(final String id) {
    if (Objects.nonNull(id)) {
      return getDao().findById(id);
    }
    return Mono.empty(); // throw unchecked exception
  }

  @Override
  @Transactional(readOnly = true)
  public Flux<T> findAll() {
    return getDao().findAll();
  }

  // save/create/persist

  @Override
  public Mono<T> create(final T entity) {
    Preconditions.checkNotNull(entity);
    if (Objects.isNull(entity.getId())) {
      return saveOp(entity);
    }
    return Mono.empty();
  }

  // update/merge

  @Override
  public Mono<T> update(final T entity) {
    Preconditions.checkNotNull(entity);

    return findOne(entity.getId()).filter(entry -> ServicePreconditions.checkEntityExists(entry))
        .flatMap(entry -> saveOp(entry));

  }

  private Mono<T> saveOp(T entry) {
    return getDao().save(entry);
  }

  // delete

  @Override
  public void deleteAll() {

    getDao().deleteAll();
  }

  @Override
  public void delete(final String id) {
    Preconditions.checkNotNull(id);

    findOne(id).filter(entry -> ServicePreconditions.checkEntityExists(entry))
        .flatMap(entry -> getDao().delete(entry));

    // entity.subscribe(value -> { ServicePreconditions.checkEntityExists(entity);
    // getDao().delete(entity);
    // }, error -> error.printStackTrace(),
    // () -> Console.out.println("completed without a value"));

  }

  // count

  @Override
  public Mono<Long> count() {
    return getDao().count();
  }

  // template method

  protected abstract ReactiveCrudRepository<T, String> getDao();

  // template

  protected final Sort constructSort(final String sortBy, final String sortOrder) {

    Sort sortInfo = null;
    if (sortBy != null) {
      sortInfo = new Sort(Direction.fromString(sortOrder), sortBy);
    }
    return sortInfo;
  }
}
