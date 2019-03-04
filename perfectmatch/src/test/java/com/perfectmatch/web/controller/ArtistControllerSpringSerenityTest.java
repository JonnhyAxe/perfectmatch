package com.perfectmatch.web.controller;

import org.junit.Before;
//import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.services.impl.ArtistServiceBean;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.junit.spring.integration.SpringIntegrationClassRule;
import net.thucydides.core.annotations.Steps;
//https://www.baeldung.com/serenity-spring-jbehave
@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//@ContextConfiguration(classes = ArtistController.class)
public class ArtistControllerSpringSerenityTest {
  
  private static final String ARTIST_ID = "2";

private static final String AWESOME_ARTIST_NAME = "AwesomeArtistName";

  private static final String CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN = "Check that Artist Name and ID is filled in.";

  private static final String CHECK_THAT_ARTIST_IS_RETREIVED = "Check that Artist is retreived.";

  private static final String CHECK_THAT_ARTIST_DOES_NOT_EXIST = "Check that Artist does not exist.";

  private static final String CHECK_THAT_ERROR_MESSAGE = "Check that error message";

  private MockMvc mvc;
  
  @Autowired private ArtistController artistController;

	public ArtistController getArtistController() {
	  return artistController;
	}
	
	public void setArtistController(ArtistController artistController) {
		this.artistController = artistController;
	}

	private ArtistServiceBean artistService;

  // These object will be magically initialized by the initFields method below.
  private JacksonTester<Artist> 	jsonArtist;
  private JacksonTester<ApiError> 	jsonApiError;
  
  @Steps ArtistRestSteps steps;
  
  @Rule public SpringIntegrationClassRule springIntegration = new SpringIntegrationClassRule();


//  @Before
//  public void init() {
//      RestAssuredMockMvc.standaloneSetup(new PlainAdderController());
//  }
  
  @Before
  public void setup() {
      // Initializes the JacksonTester
      JacksonTester.initFields(this, new ObjectMapper());
      this.artistController = new ArtistController();
      artistService = Mockito.mock(ArtistServiceBean.class);
       this.artistController.setArtistService(artistService);
      // MockMvc standalone approach
      mvc = MockMvcBuilders.standaloneSetup(artistController)
              .setControllerAdvice(new RestResponseEntityExceptionHandler(),
            		  new ArtistControllerExceptionHandler()
            		  )
//              .addFilters(new Artist())
              .build();
      
      steps.setMockMvc(mvc);
  }
  
  
  @Test
  public void canCreateArtistSerenity() throws Exception {

	  steps.givenTheArtist(AWESOME_ARTIST_NAME, ARTIST_ID);
	  steps.whenCreateTheArtist(jsonArtist);
	  steps.thenTheArtistIsCreatedCorretly(AWESOME_ARTIST_NAME, jsonArtist);
	  
  }
  
  
  
  
  
}
