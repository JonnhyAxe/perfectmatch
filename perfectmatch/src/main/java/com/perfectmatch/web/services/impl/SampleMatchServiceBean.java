package com.perfectmatch.web.services.impl;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.web.services.MusicMatchService;

import net.thucydides.core.annotations.NotImplementedException;

/**
 *
 * Expose web services for Match Entity
 *
 */
@Service
public class SampleMatchServiceBean extends AbstractRawService<Match> implements MusicMatchService {

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

	@Override
	public boolean contains(Match newMatch) {
		throw new NotImplementedException("Match operation not valid");
	}

    /*
     * (non-Javadoc)
     *
     * @see
     * com.perfectmatch.common.interfaces.ByNameSearchable#findByName(java.lang.
     * String)
     */
//    @Override
//    public Match findByName(String name) {
//
//        return this.getDao().findByName(name);
//    }

}
