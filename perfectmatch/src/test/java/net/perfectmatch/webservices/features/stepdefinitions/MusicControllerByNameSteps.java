package net.perfectmatch.webservices.features.stepdefinitions;

import static org.hamcrest.Matchers.is;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MusicControllerByNameSteps {
	
   private String ISO_CODE_SEARCH = "http://localhost:8081/music/";
   private Response response;

   
   @Step
   public void searchMusicByName(String name){
       response = SerenityRest.when().get(ISO_CODE_SEARCH + name);
   }

   @Step
   public void searchIsExecutedSuccesfully(){
       response.then().statusCode(200);
   }

   
   @Step
   public void shouldContainsIdForMusicNumber(String id){
       response.then().body("id", is(id));
   }
   
   
   @Step
   public void shouldContainsArtistNameForMusicNumber(String name){
       response.then().body("artist", is(name));
   }
   

 
}
