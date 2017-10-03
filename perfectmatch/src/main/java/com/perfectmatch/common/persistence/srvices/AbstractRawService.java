/*
 * Copyright 2017 by Brisa Inovação e Tecnologia S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information
 * of Brisa, SA ("Confidential Information").  You
 * shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 * you entered into with Brisa.
 */
package com.perfectmatch.common.persistence.srvices;


import java.util.ArrayList;
import java.util.List;

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

    // search

    // find - one

    @Override
    @Transactional(readOnly = true)
    public T findOne(final long id) {

        return getDao().findOne(id);
    }

    // find - all

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
        return getDao().save(entity);
    }

    // update/merge

    @Override
    public void update(final T entity) {

        Preconditions.checkNotNull(entity);

        getDao().save(entity);
    }

    // delete

    @Override
    public void deleteAll() {

        getDao().deleteAll();
    }

    @Override
    public void delete(final long id) {

        final T entity = getDao().findOne(id);
        ServicePreconditions.checkEntityExists(entity);

        getDao().delete(entity);
    }

    // count

    @Override
    public long count() {

        return getDao().count();
    }

    // template method

    protected abstract PagingAndSortingRepository<T, Long> getDao();
    //protected abstract JpaSpecificationExecutor<T> getSpecificationExecutor();

    // template

    protected final Sort constructSort(final String sortBy, final String sortOrder) {

        Sort sortInfo = null;
        if (sortBy != null) {
            sortInfo = new Sort(Direction.fromString(sortOrder), sortBy);
        }
        return sortInfo;
    }

}