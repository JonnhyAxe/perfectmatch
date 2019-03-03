package net.perfectmatch.webservices.features.stepdefinitions;

import static org.hamcrest.Matchers.is;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

public class MusicControllerRepositoryCreateArtistSteps {

  private String ISO_CODE_SEARCH = "http://localhost:8081/music";
  private Response response;

  @Given("^A complete fetch of music repository")
  public void searchMusics() {
    response = SerenityRest.when().get(ISO_CODE_SEARCH);
    searchIsExecutedSuccesfully();
  }

  @When("^I have a successfully response")
  public void searchIsExecutedSuccesfully() {
    response.then().statusCode(200);
  }

  @Then("^music number '(.*)' should contains id '(.*)'")
  public void shouldContainsIdForMusicNumber(int number, String id) {
    response.then().body("[" + number + "].id", is(id));
  }

  @Then("^music number '(.*)' should contains artist name '(.*)'")
  public void shouldContainsArtistNameForMusicNumber(int number, String name) {
    response.then().body("[" + number + "].artist", is(name));
  }

  @Then("^music number '(.*)' should contains artist Music name '(.*)'")
  public void shouldContainsMusicNameForMusicNumber(int number, String name) {
    response.then().body("[" + number + "].name", is(name));
  }
}
