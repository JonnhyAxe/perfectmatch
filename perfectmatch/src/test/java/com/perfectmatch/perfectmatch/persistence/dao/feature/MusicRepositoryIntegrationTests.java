package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.web.services.MusicService;
import com.perfectmatch.web.services.PerfectMatchService;
import com.perfectmatch.web.services.SampleService;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
/**
 * Integration Test between JPA and Persistence modules
 *
 */
//@RunWith(SpringIntegrationSerenityRunner.class) //does not produce report inside index
@RunWith(CucumberWithSerenity.class) //TODO does not autowire and do not run an server, only wires beans under the path
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@CucumberOptions(
  features = "src/test/resources/features/persistence/search_musics/music_repository.feature"
)
@ContextConfiguration(classes = {PerfectMatchServiceConfig.class })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@EnableMongoRepositories(basePackages = {"com.perfectmatch.persistence"})
//@ComponentScan({"com.perfectmatch.perfectmatch.persistence.dao.feature.steps"})

//this loads two contexts (backend service - @SpringBootTest AND SpringIntegrationSerenityRunner)
//the SpringIntegrationSerenityRunner does not scan application dependencies,
//they are only autowired in the current class - try to remove @SpringBootTest and add @DataMongoTest
//Refactor this to use pure web test. Note: use Controller tests 
@Ignore
public class MusicRepositoryIntegrationTests {

//  @Rule public SpringIntegrationClassRule springIntegration = new SpringIntegrationClassRule();

  @LocalServerPort private int port;

  @Steps MusicDaoRepositorySteps musicDaoRepositorySteps;

  @Autowired private MusicService musicService;

  @Autowired private PerfectMatchService sampleMatchService;

  @Autowired private SampleService sampleService;
  
//  @Before
//  public void testMe() {
//	  
//	  System.out.print("");
//  }



//      @Test
//      public void testMusicByName() throws Exception {
//      	//Given music repository
//      	musicDaoRepositorySteps.setRepository(musicService);
//      	musicDaoRepositorySteps.searchMusics();
//  
//      	//When I get music with name 'Please Stop (Original Mix)'
//      	musicDaoRepositorySteps.repository("Please Stop (Original Mix)");
//  
//      	//Then music should contain artist name 'Latmun'
//      	musicDaoRepositorySteps.shouldContainsArtistName("Latmun");
//  
//      	//Then music should contain id
//      	musicDaoRepositorySteps.shouldContainsId();
//      }

}
