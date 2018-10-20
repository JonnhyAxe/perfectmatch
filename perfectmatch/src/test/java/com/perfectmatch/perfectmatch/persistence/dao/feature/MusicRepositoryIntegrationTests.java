package com.perfectmatch.perfectmatch.persistence.dao.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.perfectmatch.perfectmatch.persistence.dao.feature.steps.MusicDaoRepositorySteps;
import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;

import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;


/**
 * Integration Test between JPA and Persistence modules
 *
 */
@RunWith(SpringIntegrationSerenityRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@CucumberOptions(features="src/test/resources/features/persistence/search_musics/music_repository.feature")
public class MusicRepositoryIntegrationTests {

	@Steps
	MusicDaoRepositorySteps musicDaoRepositorySteps;
	
	
    @Autowired
    private MusicRepository repository;

    @Test
    public void testAllMusics() throws Exception {
        List<Music> musics = repository.findAll();
        assertFalse(musics.isEmpty());
        assertEquals(3, musics.size());
    }

    @Before 
    public void init() {
    	musicDaoRepositorySteps.setRepository(repository);
    }
    
    @Test
    public void testMusicByName() throws Exception {
    	//Given music repository
    	musicDaoRepositorySteps.searchMusics();
        
    	//When I get music with name 'Please Stop (Original Mix)'
    	musicDaoRepositorySteps.repository("Please Stop (Original Mix)");
   
    	//Then music should contain artist name 'Latmun'
    	musicDaoRepositorySteps.shouldContainsArtistName("Latmun");
    	
    	//Then music should contain id
    	musicDaoRepositorySteps.shouldContainsId();
    }

    
}
