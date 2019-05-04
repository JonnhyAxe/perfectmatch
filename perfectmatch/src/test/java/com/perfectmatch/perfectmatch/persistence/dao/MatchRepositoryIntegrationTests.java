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
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Ignore // this a web test that require the app running locally
public class MatchRepositoryIntegrationTests {

  @Autowired
  private SampleMatchRepository repository;

  @Test
  public void testAllMusics() throws Exception {

    Flux<Match> fluxOfMatchs = repository.findAll();
    List<Match> matchs = fluxOfMatchs.collectList().block();
    assertFalse(matchs.isEmpty());
    assertEquals(1, matchs.size());
  }
}
