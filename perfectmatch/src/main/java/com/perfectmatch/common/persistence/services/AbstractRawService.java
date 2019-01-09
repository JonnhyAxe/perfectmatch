package com.perfectmatch.common.persistence.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.assertj.core.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.perfectmatch.common.ServicePreconditions;
import com.perfectmatch.common.interfaces.IOperations;
import com.perfectmatch.common.model.NameableEntity;

@Transactional
public abstract class AbstractRawService<T extends NameableEntity> implements IOperations<T> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  public AbstractRawService() {
    super();
  }

  // API
  @Override
  @Transactional(readOnly = true)
  public T findOne(final String id) {
	Optional<T> entity =  getDao().findById(id);
    if (Objects.nonNull(id) && entity.isPresent()) {
      return getDao().findById(id).get();
    }
    return null;
  }

  @Override
  @Transactional(readOnly = true)
  public List<T> findAll() {

    List<T> list = new ArrayList<>();
    getDao().findAll().forEach(list::add);
    return list;
  }

  // save/create/persist

  @Override
  public T create(final T entity) {
    Preconditions.checkNotNull(entity);
    if(Objects.nonNull(entity.getId())) {
    	 final T entityExists = findOne(entity.getId());
    	    if (Objects.nonNull(entityExists)) {
    	      return entityExists;
    	    }
    }
    return getDao().save(entity);
  }

  // update/merge

  @Override
  public void update(final T entity) {
    Preconditions.checkNotNull(entity);

    final T entityExists = findOne(entity.getId());
    ServicePreconditions.checkEntityExists(entityExists);
    getDao().save(entity);
  }

  // delete

  @Override
  public void deleteAll() {

    getDao().deleteAll();
  }

  @Override
  public void delete(final String id) {
    Preconditions.checkNotNull(id);

    final T entity = findOne(id);
    ServicePreconditions.checkEntityExists(entity);
    getDao().delete(entity);
  }

  // count

  @Override
  public long count() {

    return getDao().count();
  }

  // template method

  protected abstract PagingAndSortingRepository<T, String> getDao();

  // template

  protected final Sort constructSort(final String sortBy, final String sortOrder) {

    Sort sortInfo = null;
    if (sortBy != null) {
      sortInfo = new Sort(Direction.fromString(sortOrder), sortBy);
    }
    return sortInfo;
  }
}
