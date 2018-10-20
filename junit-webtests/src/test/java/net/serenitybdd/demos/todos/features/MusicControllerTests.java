package net.serenitybdd.demos.todos.features;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search_musics/filter_music_by_name.feature")
public class MusicControllerTests {
   
}