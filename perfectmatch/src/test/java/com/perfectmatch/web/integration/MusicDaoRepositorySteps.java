package com.perfectmatch.web.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.web.client.api.MusicControllerApi;
import com.perfectmatch.web.client.model.Music;

import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Step;


@Slf4j
@Component
@ContextConfiguration(classes = { IntegrationSwaggerAPI.class })
public class MusicDaoRepositorySteps {

	@Autowired 
	private MusicControllerApi musicControllerApi;

	private Music music;
	
		
	@Step("I search music by name '{0}'")
	public void findMusicByName(String name) {
	  log.info("getMusicByNameUsingGET");
	  music = musicControllerApi.getMusicByNameUsingGET(name);
	  assertNotNull(music);
	  log.info("Music: '{}'", music);
	}
	
	@Step("Music should contain id")
	public void shouldContainId() {
	    assertTrue(!music.getId().equals(0));
	}
	
	@Step("Music should contains artist name '{0}'")
	public void shouldContainsArtistName(String name) {
		assertTrue(music.getArtists().contains(name));
	}


}
