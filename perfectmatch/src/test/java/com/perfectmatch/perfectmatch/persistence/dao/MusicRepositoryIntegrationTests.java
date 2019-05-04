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
import reactor.core.publisher.Flux;

/**
 * Integration Test between JPA and Persistence modules
 *
 */
// @Ignore //this a web test that require the app running locally

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Ignore
public class MusicRepositoryIntegrationTests {

  @Autowired
  private MusicRepository repository;

  @Test
  public void testAllMusics() throws Exception {

    Flux<Music> fluxOfMusics = repository.findAll();
    List<Music> musics = fluxOfMusics.collectList().block();
    assertFalse(musics.isEmpty());
    assertEquals(3, musics.size());
  }
}
