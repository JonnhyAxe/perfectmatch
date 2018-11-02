package com.perfectmatch.perfectmatch.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;

/**
 * Integration Test between JPA and Persistence modules
 *
 */
@Ignore //this a web test that require the app running locally

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SampleRepositoryIntegrationTests {

    @Autowired
    private SampleRepository repository;
//
    @Test
    public void testAllSamples() throws Exception {

        List<Sample> musics = repository.findAll();
        assertFalse(musics.isEmpty());
        assertEquals(2, musics.size());
    }

}
