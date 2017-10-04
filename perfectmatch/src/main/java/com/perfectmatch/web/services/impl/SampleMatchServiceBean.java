package com.perfectmatch.web.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.srvices.AbstractRawService;
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.web.services.SampleMatchService;

/**
 *
 * Expose web services for Match Entity
 *
 */
@Service
@Transactional
public class SampleMatchServiceBean extends AbstractRawService<Match> implements SampleMatchService {

    @Autowired
    private SampleMatchRepository dao;

    /*
     * (non-Javadoc)
     *
     * @see
     * com.perfectmatch.common.persistence.srvices.AbstractRawService#getDao()
     */
    @Override
    protected SampleMatchRepository getDao() {

        return this.dao;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.perfectmatch.common.interfaces.ByNameSearchable#findByName(java.lang.
     * String)
     */
    @Override
    public Match findByName(String name) {

        return this.getDao().findByName(name);
    }

}
