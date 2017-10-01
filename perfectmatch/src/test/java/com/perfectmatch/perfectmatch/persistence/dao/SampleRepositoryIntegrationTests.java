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
package com.perfectmatch.perfectmatch.persistence.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;

/**
 * Integration Test between JPA and Persistence modules
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class SampleRepositoryIntegrationTests {

    @Autowired
    private SampleRepository repository;

    @Test
    public void testAllSamples() throws Exception {

        List<Sample> musics = repository.findAll();
        assertFalse(musics.isEmpty());
        assertEquals(2, musics.size());
    }

}
