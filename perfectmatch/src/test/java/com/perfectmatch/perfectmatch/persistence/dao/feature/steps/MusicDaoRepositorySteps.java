package com.perfectmatch.perfectmatch.persistence.dao.feature.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

public class MusicDaoRepositorySteps {
	
//   @Autowired
   private MusicRepository repository;
   private Music music;
   
   @Given("^music repository")
   public void searchMusics(){
	   assertNotNull("Repository does not exists", repository);
   }

   @When("^I get music with name '(.*)'")
   public void repository(String name){
	   music = repository.findByName(name);
	   assertNotNull(music);
   }

   @Then("^music should contain id")
   public void shouldContainsId(){
       assertTrue(!music.getId().equals(0));
   }
   
   @Then("^music should contains artist name '(.*)'")
   public void shouldContainsArtistName(String name ){
	   assertEquals(name, music.getArtist());
   }
  
   public void setRepository(MusicRepository repository) {
	   this.repository = repository;
   }	
}
