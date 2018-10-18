package steps;

import static org.hamcrest.Matchers.is;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class MusicControllerRepositorySteps {
	
   private String ISO_CODE_SEARCH = "http://localhost:8081/music";
   private Response response;

   
   @Step
   public void searchMusics(){
       response = SerenityRest.when().get(ISO_CODE_SEARCH);
   }

   @Step
   public void searchIsExecutedSuccesfully(){
       response.then().statusCode(200);
   }

   
   @Step
   public void shouldContainsIdForMusicNumber(String id, int number){
       response.then().body("[" + number + "].id", is(id));
   }
   
   
   @Step
   public void shouldContainsArtistNameForMusicNumber(String name, int number){
       response.then().body("[" + number + "].artist", is(name));
   }
   
   @Step
   public void shouldContainsMusicNameForMusicNumber(String name, int number){
       response.then().body("[" + number + "].name", is(name));
   }
   
 
}
