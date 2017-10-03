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
package com.perfectmatch.web.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfectmatch.common.persistence.srvices.AbstractRawService;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.services.MusicService;

/**
 * <class description>
 *
 */
@Service
@Transactional
public class MusicServiceBean extends AbstractRawService<Music> implements MusicService {

    @Autowired
    private MusicRepository dao;

    /**
     * @return the dao
     */
    public MusicRepository getDao() {

        return dao;
    }

    public Music findByName(final String name) {

        return getDao().findByName(name);
    }

}
