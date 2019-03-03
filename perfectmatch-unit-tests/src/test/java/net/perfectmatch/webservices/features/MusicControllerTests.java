package net.perfectmatch.webservices.features;


import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search_musics/filter_music_by_name.feature")
@Profile("UAT")
public class MusicControllerTests {
   
}