package net.perfectmatch.webservices.features.stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertTrue;

import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class MusicControllerRepositorySteps {

  private String ISO_CODE_CREATE = "http://localhost:8081/music"; //add host to maven pom
  private Response response;

  private String musicName = null;
  private String style = null;
  private List<String> remixers;
  private String recordLabel;
  private String key = null;
  private String tempo = null;
  private String energy = null;

  @Given("^the music name '(.*)'")
  public void given_music_name(String musicName) {
    this.musicName = musicName;
  }

  @Given("^the music style '(.*)'")
  public void given_music_style(String musicStyle) {
    this.style = musicStyle;
  }

  @Given("^the Key '(.*)'")
  public void given_music_key(String key) {
    this.key = key;
  }

  @Given("^the Tempo '(.*)'")
  public void given_music_tempo(String tempo) {
    this.tempo = tempo;
  }

  @Given("^the Energy '(.*)'")
  public void given_music_energy(String energy) {
    this.energy = energy;
  }

  @Given("^the music with audio file with metadata$")
  public void the_music_with_audio_file_with_metadata() {
    throw new PendingException();
  }

  @Given("^remixers names")
  public void givenRemixersNames(List<String> remixers) {
    this.remixers = remixers;
  }

  @Given("^record label name '(.*)'")
  public void i_update_with_remixers(String recordLabel) {
    this.recordLabel = recordLabel;
  }

  @When("^I create the music for '(.*)' artist")
  public void createMusic(String artist) {

    JsonArray jsonArr = new JsonArray();
    jsonArr.add(artist);

    JsonObject music = new JsonObject();
    music.add("artists", jsonArr);
    music.addProperty("name", musicName);
    music.addProperty("style", style);

    response =
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(music.toString())
            .when()
            .post(ISO_CODE_CREATE);
  }

  @When("^I create the music with artists")
  public void createMusicWithArtists(List<String> artists) {

    JsonArray jsonArr = new JsonArray();
    artists.stream().forEach((var artist) -> jsonArr.add(artist));

    JsonObject music = new JsonObject();
    music.add("artists", jsonArr);
    music.addProperty("name", musicName);
    music.addProperty("style", style);

    response =
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(music.toString())
            .when()
            .post(ISO_CODE_CREATE);
  }

  @Given(
      "^and the source file provider 'https://www\\.youtube\\.com/watch\\?v=(\\d+)SdvDZS(\\d+)MIQ'$")
  public void and_the_source_file_provider_https_www_youtube_com_watch_v_SdvDZS_MIQ(
      int arg1, int arg2) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^I search for the Key$")
  public void i_search_for_the_Key() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @When("^I update music$")
  public void i_update_music() {
    JsonArray jsonArr = new JsonArray();
    remixers.stream().forEach((var remixers) -> jsonArr.add(remixers));

    JsonObject music = new JsonObject();
    music.addProperty("name", musicName);
    music.add("remixers", jsonArr);
    music.addProperty("recordLabel", recordLabel);
    music.addProperty("key", recordLabel);
    music.addProperty("recordLabel", recordLabel);
    music.addProperty("recordLabel", recordLabel);

    response =
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(music.toString())
            .when()
            .put(ISO_CODE_CREATE);
  }

  @When("^I update music metadata$")
  public void i_update_music_metadata() {

    JsonObject music = new JsonObject();
    music.addProperty("name", musicName);
    music.addProperty("key", key);
    music.addProperty("tempo", tempo);
    music.addProperty("energy", energy);

    response =
        given()
            .accept(ContentType.JSON)
            .contentType(ContentType.JSON)
            .body(music.toString())
            .when()
            .put(ISO_CODE_CREATE);
  }

  @When("^I add the audio file$")
  public void i_add_the_audio_file() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("^the music contains playable audio file$")
  public void the_music_contains_playable_audio_file() {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then(
      "^the music contains audio file provider 'https://www\\.youtube\\.com/watch\\?v=(\\d+)SdvDZS(\\d+)MIQ'$")
  public void the_music_contains_audio_file_provider_https_www_youtube_com_watch_v_SdvDZS_MIQ(
      int arg1, int arg2) {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
  }

  @Then("the music contains remixer:")
  public void the_music_contains_remixers(List<String> remixers) {
    JsonPath jsonPathEvaluator = response.jsonPath();
    List<String> allRemixers = jsonPathEvaluator.getList("music.remixers", String.class);
    remixers
        .stream()
        .forEach( (var remixer)  -> {
              assertTrue("Remixer name " + remixer + " does not exist", allRemixers.contains(remixer));
            });
  }

  @Then("^the music contains record label '(.*)'$")
  public void the_music_contains_record_label_Vendetta_Records(String recordLabel) {
    response.then().body("music.recordLabel", is(recordLabel));
  }

  @Then("^the music Energy is '(.*)'$")
  public void theMusicEnergyIs(String energy) {
    response.then().body("music.energy", is(energy));
  }

  @Then("^the music Tempo is '(.*)'$")
  public void theMusicTempoIs(String tempo) {
    response.then().body("music.tempo", is(tempo));
  }

  @Then("^the music is created")
  public void musicIsCreated() {
    response.then().statusCode(201);
  }

  @Then("^the music is not created")
  public void musicIsNotCreated() {
    response.then().statusCode(500);
  }

  @Then("^the music contains an id")
  public void musicContainsId() {
    response.then().body("music.id", notNullValue());
  }

  @Then("^the music artist name is '(.*)'")
  public void musicShouldContainsArtistName(String artistName) {
    response.then().body("music.artist", is(artistName));
  }

  @Then("^the music name is '(.*)'")
  public void musicShouldContainsName(String name) {
    response.then().body("music.name", is(name));
  }

  @Then("^the music style is '(.*)'")
  public void musicShouldContainsStyle(String name) {
    response.then().body("music.style", is(name));
  }

  @Then("^the reason is Artist Name '(.*)' not found$")
  public void the_reason_is_Artist_name_already_created(String artist) {
    response.then().body("message", is("Artist Name " + artist + " not found"));
  }

  @Then("^the music Key is '(.*)'$")
  public void theMusickeyIs(String key) {
    response.then().body("music.key", is(key));
  }
}
