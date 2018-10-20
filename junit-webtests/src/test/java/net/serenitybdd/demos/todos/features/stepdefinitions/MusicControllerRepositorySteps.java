package net.serenitybdd.demos.todos.features.stepdefinitions;

import static org.hamcrest.Matchers.is;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MusicControllerRepositorySteps {
	
   private String ISO_CODE_SEARCH = "http://localhost:8081/music";
   private Response response;

   
   @Given("^A complete fetch of music repository")
   public void searchMusics(){
       response = SerenityRest.when().get(ISO_CODE_SEARCH);
       searchIsExecutedSuccesfully();
   }

   @When("^I have a successfully response")
   public void searchIsExecutedSuccesfully(){
       response.then().statusCode(200);
   }

   @Then("^music number '(.*)' should contains id '(.*)'")
   public void shouldContainsIdForMusicNumber(int number, String id){
       response.then().body("[" + number + "].id", is(id));
   }
   
   
   @Then("^music number '(.*)' should contains artist name '(.*)'")
   public void shouldContainsArtistNameForMusicNumber(int number, String name ){
       response.then().body("[" + number + "].artist", is(name));
   }
   
   @Then("^music number '(.*)' should contains artist Music name '(.*)'")
   public void shouldContainsMusicNameForMusicNumber(int number, String name){
       response.then().body("[" + number + "].name", is(name));
   }
//   
//    @Given("^I have a todo list containing (.*)$")
//    public void i_have_a_todo_list_containing(List<String> thingsToDo) throws Throwable {
////        jane.attemptsTo(addSomeItems.called(thingsToDo));
//    }
//
//    @When("^I delete the todo action 'Buy some milk'$")
//    public void i_delete_the_todo_action_Buy_some_milk() throws Throwable {
//    }
//
//    @Then("^my todo list should contain 'Buy Petrol'$")
//    public void my_todo_list_should_contain_Buy_Petrol() throws Throwable {
//    }
//
//    @Given("^I have marked the 'Buy some milk' action as complete$")
//    public void i_have_marked_the_Buy_some_milk_action_as_complete() throws Throwable {
//    }

}
