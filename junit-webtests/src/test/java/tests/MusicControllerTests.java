package tests;


import java.net.URLEncoder;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

//@RunWith(SerenityRunner.class)

import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Steps;
import steps.MusicControllerByNameSteps;
import steps.MusicControllerRepositorySteps;

@RunWith(CucumberWithSerenity.class)

public class MusicControllerTests {
   
	@Steps
	MusicControllerRepositorySteps musicControllerRepositorySteps;

	@Steps
	MusicControllerByNameSteps musicControllerByNameSteps;
	
	@Test
	public void verifyThatWeCanFindLatmunPleaseStopMusicInTheRepository(){
		musicControllerRepositorySteps.searchMusics();
		musicControllerRepositorySteps.searchIsExecutedSuccesfully();
		musicControllerRepositorySteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79597", 0);
		musicControllerRepositorySteps.shouldContainsArtistNameForMusicNumber("Latmun", 0);
		musicControllerRepositorySteps.shouldContainsMusicNameForMusicNumber("Please Stop (Original Mix)", 0);
	}
   
	@Test
	public void verifyThatWeCanFindLatmunDefMusicInTheRepository(){
		musicControllerRepositorySteps.searchMusics();
		musicControllerRepositorySteps.searchIsExecutedSuccesfully();
		musicControllerRepositorySteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79598", 1);
		musicControllerRepositorySteps.shouldContainsArtistNameForMusicNumber("Latmun", 1);
		musicControllerRepositorySteps.shouldContainsMusicNameForMusicNumber("def (Original Mix)", 1);
	}
   
	@Test
    public void verifyThatWeCanFindLatmunPleaseStopXPTOMusicInTheRepository(){
		musicControllerRepositorySteps.searchMusics();
		musicControllerRepositorySteps.searchIsExecutedSuccesfully();
		musicControllerRepositorySteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79599", 2);
		musicControllerRepositorySteps.shouldContainsArtistNameForMusicNumber("LatmunXPTO", 2);
		musicControllerRepositorySteps.shouldContainsMusicNameForMusicNumber("Please Stop (Original Mix)XPTO", 2);
    }
    
    
    @Test
    @Ignore
    public void verifyThatWeCanFindLatmunPleaseStopXPTOMusicByName(){
    	musicControllerByNameSteps.searchMusicByName(URLEncoder.encode("Please Stop (Original Mix)XPTO") );
    	musicControllerByNameSteps.searchIsExecutedSuccesfully();
    	musicControllerByNameSteps.shouldContainsIdForMusicNumber("5bc8e3b6f0139411c4a79599");
    	musicControllerByNameSteps.shouldContainsArtistNameForMusicNumber("Latmun");
    }
}