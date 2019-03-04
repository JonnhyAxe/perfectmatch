package com.perfectmatch.perfectmatch.persistence.dao.feature;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.services.AdderService;
import com.perfectmatch.web.services.MusicService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class MusicDaoRepositorySteps {

  @Autowired 
  private MusicService repository;
  
  @Autowired
  private AdderService adderService;
  
  private Music music;

  @Given("^music repository")
  public void searchMusics() {
    assertNotNull("AdderService does not exists", getAdderService());
  }

  @When("^I get music with name '(.*)'")
  public void repository(String name) {
    music = repository.findByName(name);
    assertNotNull(music);
  }

  @Then("^music should contain id")
  public void shouldContainsId() {
    assertTrue(!music.getId().equals(0));
  }

  @Then("^music should contains artist name '(.*)'")
  public void shouldContainsArtistName(String name) {
    assertEquals(name, music.getArtist());
  }

  public void setRepository(MusicService repository) {
    this.repository = repository;
  }

	public AdderService getAdderService() {
		return adderService;
	}
	
	public void setAdderService(AdderService adderService) {
		this.adderService = adderService;
	}
}