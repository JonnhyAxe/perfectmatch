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

import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;

/**
 * Integration Test between JPA and Persistence modules
 *
 */
@Ignore //this a web test that require the app running locally

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MusicRepositoryIntegrationTests {

    @Autowired
    private MusicRepository repository;

    @Test
    public void testAllMusics() throws Exception {

        List<Music> musics = repository.findAll();
        assertFalse(musics.isEmpty());
        assertEquals(3, musics.size());
    }

}
