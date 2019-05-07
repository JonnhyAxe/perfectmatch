
package com.perfectmatch.web.integration;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import net.serenitybdd.junit.spring.integration.SpringIntegrationClassRule;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;

@RunWith(SpringIntegrationSerenityRunner.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@ContextConfiguration(classes = {PerfectMatchServiceConfig.class, IntegrationSwaggerAPI.class,
    CustomizationWebServer.class})
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
// @EnableMongoRepositories(basePackages = {"com.perfectmatch.persistence"})
@EnableReactiveMongoRepositories(basePackages = {"com.perfectmatch.persistence"})
@Ignore //
public class MusicRepositoryIntegrationTests {

  @Rule
  public SpringIntegrationClassRule springIntegration = new SpringIntegrationClassRule();


  @Steps
  MusicDaoRepositorySteps musicDaoRepositorySteps;


  @Test
  public void getLatmunMusicPleaseStop() {
    String musicName = "Please Stop (Original Mix)";
    String artistName = "Latmun";

    musicDaoRepositorySteps.findMusicByName(musicName);
    musicDaoRepositorySteps.shouldContainId();
    musicDaoRepositorySteps.shouldContainsArtistName(artistName);
  }


}
