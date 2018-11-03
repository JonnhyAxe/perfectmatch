package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.perfectmatch.persistence.dao.feature.steps.MusicDaoRepositorySteps;
import com.perfectmatch.web.services.MusicService;
import com.perfectmatch.web.services.SampleMatchService;
import com.perfectmatch.web.services.SampleService;

import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
/**
 * Integration Test between JPA and Persistence modules
 *
 */
@RunWith(SpringIntegrationSerenityRunner.class) //doesn not produce report inside index
//@RunWith(SerenityRunner.class)
//@RunWith(CucumberWithSerenity.class) //TODO does not autowire
@EnableAutoConfiguration
@CucumberOptions(features="src/test/resources/features/persistence/search_musics/music_repository.feature")
@ContextConfiguration(classes = { PerfectMatchServiceConfig.class })
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableMongoRepositories(basePackages = {"com.perfectmatch.persistence"})//, "com.perfectmatch.web"
public class MusicRepositoryIntegrationTests {

//    @Rule public SpringIntegrationMethodRule springIntegration = new SpringIntegrationMethodRule();

    
	@Steps
	MusicDaoRepositorySteps musicDaoRepositorySteps;
	
    @Autowired
    private MusicService musicService;
    
    @Autowired  
    private SampleMatchService sampleMatchService;
    
    @Autowired  
    private SampleService sampleService;
       


//    @Test
//    public void testAllMusics() throws Exception {
//        List<Music> musics = repository.findAll();
//        assertFalse(musics.isEmpty());
//        assertEquals(3, musics.size());
//    }


    
//    @DirtiesContex
    @Test
    public void testMusicByName() throws Exception {
    	//Given music repository
    	musicDaoRepositorySteps.setRepository(musicService);
    	musicDaoRepositorySteps.searchMusics();
        
    	//When I get music with name 'Please Stop (Original Mix)'
    	musicDaoRepositorySteps.repository("Please Stop (Original Mix)");
   
    	//Then music should contain artist name 'Latmun'
    	musicDaoRepositorySteps.shouldContainsArtistName("Latmun");
    	
    	//Then music should contain id
    	musicDaoRepositorySteps.shouldContainsId();
    }

    
}
