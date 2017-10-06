package com.perfectmatch.perfectmatch.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.perfectmatch.perfectmatch.spring.PerfectMatchWebConfig;
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.spring.PerfectMatchPersistenceJpaConfig;
import com.perfectmatch.spring.PerfectMatchServletConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { PerfectMatchPersistenceJpaConfig.class, PerfectMatchWebConfig.class,
        PerfectMatchServletConfig.class }, loader = AnnotationConfigContextLoader.class)
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
