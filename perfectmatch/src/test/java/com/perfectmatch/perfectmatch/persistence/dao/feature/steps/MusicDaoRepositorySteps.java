package com.perfectmatch.perfectmatch.persistence.dao.feature.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import com.perfectmatch.perfectmatch.persistence.dao.feature.IntegrationSwaggerAPI;
import com.perfectmatch.web.client.api.MusicControllerApi;
import com.perfectmatch.web.client.model.Music;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
@ContextConfiguration(classes = { IntegrationSwaggerAPI.class })
public class MusicDaoRepositorySteps {

	@Autowired 
	private MusicControllerApi musicControllerApi;

	private Music music;

	  @Given("^music repository")
	  public void searchMusics() {
	    assertNotNull("AdderService does not exists", musicControllerApi);
	  }
	
	  @When("^I get music with name '(.*)'")
	  public void repository(String name) {
	    music = musicControllerApi.getMusicByNameUsingGET(name);
	    assertNotNull(music);
	  }
	
	  @Then("^music should contain id")
	  public void shouldContainsId() {
	//    assertTrue(!music.getId().equals(0));
	  }

	  @Then("^music should contains artist name '(.*)'")
	  public void shouldContainsArtistName(String name) {
	    assertEquals(name, music.getName());
	  }


		public MusicControllerApi getMusicControllerApi() {
			return musicControllerApi;
		}

		public void setMusicControllerApi(MusicControllerApi musicControllerApi) {
			this.musicControllerApi = musicControllerApi;
		}
}
