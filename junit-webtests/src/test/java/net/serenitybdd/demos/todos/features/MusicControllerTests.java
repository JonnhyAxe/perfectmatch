package net.serenitybdd.demos.todos.features;


import java.net.URLEncoder;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
//import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.demos.todos.features.stepdefinitions.MusicControllerRepositorySteps;
import net.thucydides.core.annotations.Steps;
//import steps.MusicControllerByNameSteps;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search_musics/filter_music_by_name.feature")
//@RunWith(SerenityRunner.class)
public class MusicControllerTests {
   
//	@Steps
//	MusicControllerRepositorySteps musicControllerRepositorySteps;
//
//	@Steps
//	MusicControllerByNameSteps musicControllerByNameSteps;
//	
//	@Test
//	public void verifyThatWeCanFindLatmunPleaseStopMusicInTheRepository(){
//		musicControllerRepositorySteps.searchMusics();
//		musicControllerRepositorySteps.searchIsExecutedSuccesfully();
//		musicControllerRepositorySteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79597", 0);
//		musicControllerRepositorySteps.shouldContainsArtistNameForMusicNumber("Latmun", 0);
//		musicControllerRepositorySteps.shouldContainsMusicNameForMusicNumber("Please Stop (Original Mix)", 0);
//	}
//   
//	@Test
//	public void verifyThatWeCanFindLatmunDefMusicInTheRepository(){
//		musicControllerRepositorySteps.searchMusics();
//		musicControllerRepositorySteps.searchIsExecutedSuccesfully();
//		musicControllerRepositorySteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79598", 1);
//		musicControllerRepositorySteps.shouldContainsArtistNameForMusicNumber("Latmun", 1);
//		musicControllerRepositorySteps.shouldContainsMusicNameForMusicNumber("def (Original Mix)", 1);
//	}
//   
//	@Test
//    public void verifyThatWeCanFindLatmunPleaseStopXPTOMusicInTheRepository(){
//		musicControllerRepositorySteps.searchMusics();
//		musicControllerRepositorySteps.searchIsExecutedSuccesfully();
//		musicControllerRepositorySteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79599", 2);
//		musicControllerRepositorySteps.shouldContainsArtistNameForMusicNumber("LatmunXPTO", 2);
//		musicControllerRepositorySteps.shouldContainsMusicNameForMusicNumber("Please Stop (Original Mix)XPTO", 2);
//    }
//    
//    
//    @Test
//    @Ignore
//    public void verifyThatWeCanFindLatmunPleaseStopXPTOMusicByName(){
//    	musicControllerByNameSteps.searchMusicByName(URLEncoder.encode("Please Stop (Original Mix)XPTO") );
//    	musicControllerByNameSteps.searchIsExecutedSuccesfully();
//    	musicControllerByNameSteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79599");
//    	musicControllerByNameSteps.shouldContainsArtistNameForMusicNumber("Latmun");
//    }
//    
    

}