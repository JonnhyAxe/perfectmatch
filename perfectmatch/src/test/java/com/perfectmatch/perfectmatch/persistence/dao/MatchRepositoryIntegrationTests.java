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

import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class MatchRepositoryIntegrationTests {

    @Autowired
    private SampleMatchRepository repository;

    @Test
    public void testAllMusics() throws Exception {

        List<Match> matchs = repository.findAll();
        assertFalse(matchs.isEmpty());
        assertEquals(1, matchs.size());
    }
}
