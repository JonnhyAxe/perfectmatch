
package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
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

//this loads two contexts (backend service  @SpringBootTest AND SpringIntegrationSerenityRunner)
//the SpringIntegrationSerenityRunner does not scan application dependencies,
//they are only autowired in the current class  try to remove @SpringBootTest and add @DataMongoTest
//Refactor this to use pure web test. Note: use Controller tests 

public class MusicRepositoryIntegrationTests {




}
