package net.perfectmatch.webservices.features;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@Ignore //this a web test that require the app running locally
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
  features = "src/test/resources/features/services/create_artist/create_artist.feature"
)
@ActiveProfiles("staging")
public class ArtistControllerTests {}
