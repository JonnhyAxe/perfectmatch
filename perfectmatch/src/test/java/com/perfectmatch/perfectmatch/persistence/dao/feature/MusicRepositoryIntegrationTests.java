
package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.perfectmatch.persistence.dao.feature.steps.MusicDaoRepositorySteps;

import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.spring.integration.SpringIntegrationClassRule;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
/**
 * Integration Test between JPA and Persistence modules
 *
 */
@RunWith(SpringIntegrationSerenityRunner.class) //does not produce report inside index
//@RunWith(CucumberWithSerenity.class) //TODO does not autowire and do not run an server, only wires beans under the path
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@CucumberOptions(
  features = "src/test/resources/features/persistence/search_musics/music_repository.feature"
)
@ContextConfiguration(classes = {PerfectMatchServiceConfig.class, IntegrationSwaggerAPI.class, CustomizationWebServer.class })
@SpringBootTest
@EnableMongoRepositories(basePackages = {"com.perfectmatch.persistence"})
@ComponentScan({"com.perfectmatch.perfectmatch.persistence.dao.feature.steps"})

//this loads two contexts (backend service  @SpringBootTest AND SpringIntegrationSerenityRunner)
//the SpringIntegrationSerenityRunner does not scan application dependencies,
//they are only autowired in the current class  try to remove @SpringBootTest and add @DataMongoTest
//Refactor this to use pure web test. Note: use Controller tests 

public class MusicRepositoryIntegrationTests {

	@Rule public SpringIntegrationClassRule springIntegration = new SpringIntegrationClassRule();
//	  
//	@LocalServerPort
//	private int port;
//	
	@Steps
	MusicDaoRepositorySteps musicDaoRepositorySteps;


	 @Test
	  public void _0_givenNumber_whenAddAndAccumulate_thenSummedUp() {
	   
	  }

	 
}
