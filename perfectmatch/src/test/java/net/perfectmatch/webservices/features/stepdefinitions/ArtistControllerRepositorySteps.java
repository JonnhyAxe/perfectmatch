package net.perfectmatch.webservices.features.stepdefinitions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import java.io.UnsupportedEncodingException;

import com.google.gson.JsonObject;
import com.perfectmatch.persistence.model.Artist;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class ArtistControllerRepositorySteps {
	
   private String ISO_CODE_CREAT = "http://localhost:8081/artist";
   private Response response;
   private Response preconditionResponse;
   
   private String artistName = null;
   
   @Given("^the artist name '(.*)'$")
   public void artistNameAndWebsiteInfo(String artistName){

	   this.artistName = artistName; 
//	   this.websites = website;

   }
   
   @Given("^the artist name '(.*)' created$")
   public void artistNameCreatted(String artistName) throws UnsupportedEncodingException{
	   
	   preconditionResponse =  RestAssured.given()
			   .when().get(ISO_CODE_CREAT + "/" + java.net.URLEncoder.encode(artistName, "UTF-8").replace("+", "%20"));
	   preconditionResponse.then().statusCode(200);
   }
   
   @Given("^the artist name '(.*)' deleted$")
   public void artistNameDeleted(String artistName) throws UnsupportedEncodingException{
	   
	   preconditionResponse =  RestAssured.given()
			   .when().delete(ISO_CODE_CREAT + "/" + java.net.URLEncoder.encode(artistName, "UTF-8").replace("+", "%20"));
	   preconditionResponse.then().toString();
   }

   @When("^I create the artist")
   public void whenICreateTheArtist(){
//	   artist.getWebsites().add(websites);
	   
	   JsonObject artist = new JsonObject();
	   artist.addProperty("name", artistName);

	   response =  RestAssured
			   .given().accept(ContentType.JSON).
	           		contentType(ContentType.JSON).
	           		body(artist.toString()).
	           when().
	           		post(ISO_CODE_CREAT);
   }

   @Then("^the artist is create with an unique identifier")
   public void createdArtistHasId(){
	   response.then().statusCode(201);
	   response.then().body("id", notNullValue());
   }
   
   
   @Then("^the artist name is '(.*)'")
   public void shouldContainsArtistName(String name){
       response.then().body("name", is(name));
   }
   
//   @Then("^it contains an website link \"([^\"]*)\"$")
//   public void shouldContainsWebsiteLink(String website){
//       response.then().body("[" + 0 + "].name", is(website));
//   }

   @Then("^the result is not created$")
   public void the_result_is_not_created() {
	   response.then().statusCode(500);
   }

   @Then("^the reason is Artist Name '(.*)' already exists$")
   public void the_reason_is_Artist_name_already_created(String artist) {
	   response.then().statusCode(500);
	   response.then().body("message", is("Artist Name " + artist +" already exists"));
   }

}
