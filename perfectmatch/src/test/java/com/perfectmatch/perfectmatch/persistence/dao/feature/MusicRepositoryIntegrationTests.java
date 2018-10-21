package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.perfectmatch.persistence.dao.feature.steps.MusicDaoRepositorySteps;
import com.perfectmatch.spring.PerfectMatchPersistenceConfig;
import com.perfectmatch.web.services.impl.MusicServiceBean;

import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
/**
 * Integration Test between JPA and Persistence modules
 *
 */
@RunWith(SpringIntegrationSerenityRunner.class)
//@RunWith(CucumberWithSerenity.class)
//@EnableAutoConfiguration
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@CucumberOptions(features="src/test/resources/features/persistence/search_musics/music_repository.feature")
@ContextConfiguration(classes = {PerfectMatchPersistenceConfig.class, 
		PerfectMatchServiceConfig.class})
@Ignore //Unable to start web server; nested exception is org.springframework.context.ApplicationContextException: Unable to start ServletWebServerApplicationContext due to missing ServletWebServerFactory bean.

public class MusicRepositoryIntegrationTests {

//	@Bean 
//	  ServletWebServerFactory servletWebServerFactory(){
//	  return new TomcatServletWebServerFactory();
//	}
	
	@Steps
	MusicDaoRepositorySteps musicDaoRepositorySteps;
	
//	@Rule public SpringIntegrationMethodRule springIntegration = new SpringIntegrationMethodRule();
//	 
	
    @Autowired
    private MusicServiceBean repository;

//    @Test
//    public void testAllMusics() throws Exception {
//        List<Music> musics = repository.findAll();
//        assertFalse(musics.isEmpty());
//        assertEquals(3, musics.size());
//    }

//    @Before 
//    public void init() {
//    	System.out.println("Repos " + repository);
//    	musicDaoRepositorySteps.setRepository(repository);
//    }
    
//    @DirtiesContex
    @Test
    public void testMusicByName() throws Exception {
    	//Given music repository
    	musicDaoRepositorySteps.setRepository(repository);
    	musicDaoRepositorySteps.searchMusics();
        
    	//When I get music with name 'Please Stop (Original Mix)'
    	musicDaoRepositorySteps.repository("Please Stop (Original Mix)");
   
    	//Then music should contain artist name 'Latmun'
    	musicDaoRepositorySteps.shouldContainsArtistName("Latmun");
    	
    	//Then music should contain id
    	musicDaoRepositorySteps.shouldContainsId();
    }

    
}
