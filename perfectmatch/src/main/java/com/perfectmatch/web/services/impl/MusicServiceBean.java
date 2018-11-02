package com.perfectmatch.web.services.impl;

import java.util.List;
import java.util.Set;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.services.AbstractRawService;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.services.MusicService;

/**
 * Expose web services for Music Entity
 *
 */
@Service
//@Transactional
public class MusicServiceBean extends AbstractRawService<Music> implements MusicService {

    @Autowired
    private MusicRepository dao;

    /**
     * @return the MusicRepository
     */
    @Override
    public MusicRepository getDao() {

        return dao;
    }

    
	@Override
	public List<Music> findAll(){

        return getDao().findAll();
    }
	
    @Override
    public Music findByName(final String name) {

        return getDao().findByName(name);
    }

    @Override
    public Set<Music> findByArtist(final String name) {

        return getDao().findByArtist(name);
    }

	@Override
	public Music save(Music resource) {
		
		return getDao().save(resource);
	}

}
