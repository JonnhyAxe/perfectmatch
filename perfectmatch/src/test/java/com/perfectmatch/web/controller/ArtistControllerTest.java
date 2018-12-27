package com.perfectmatch.web.controller;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.services.impl.ArtistServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class ArtistControllerTest {
  
  private MockMvc mvc;
  
  @InjectMocks private ArtistController artistController;

  @Mock private ArtistServiceBean artistService;

  // This object will be magically initialized by the initFields method below.
  private JacksonTester<Artist> jsonArtist;

  @Before
  public void setup() {
      // Initializes the JacksonTester
      JacksonTester.initFields(this, new ObjectMapper());
      // MockMvc standalone approach
      mvc = MockMvcBuilders.standaloneSetup(artistController)
              .setControllerAdvice(new RestResponseEntityExceptionHandler())
//              .addFilters(new Artist())
              .build();
  }
  
  @Test
  public void canRetrieveByIdWhenExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName("AwesomeArtistName");
	 
      given(artistService.getArtistById("2"))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/id/2")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as("Check that Artist is retreived.")
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as("Check that Artist Name and ID is filled in.")
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByIdWhenDoesNotExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName("AwesomeArtistName");
	 
      given(artistService.getArtistById("2"))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/id/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as("Check that Artist is retreived.")
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as("Check that Artist Name and ID is filled in.")
      	.isEqualTo("");
  }
 
  
  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName("AwesomeArtistName");
	 
      given(artistService.getArtistById("2"))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/AwesomeArtistName")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as("Check that Artist is retreived.")
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as("Check that Artist Name and ID is filled in.")
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByNameWhenDoesNotExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName("AwesomeArtistName");
	 
      given(artistService.getArtistById("2"))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as("Check that Artist is retreived.")
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as("Check that Artist Name and ID is filled in.")
      	.isEqualTo("");
  }
  
  @Test
  public void canDeleteByNameWhenExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName("AwesomeArtistName");
	 
      given(artistService.deleteArtistByName("AwesomeArtistName"))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              delete("/artist/AwesomeArtistName")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as("Check that Artist is retreived.")
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as("Check that Artist Name and ID is filled in.")
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }
  
  @Test
  public void canDeleteByNameWhenDoesNotExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName("AwesomeArtistName");
	 
      given(artistService.deleteArtistByName("2"))
      .willReturn(expectedArtist);


      // when
      MockHttpServletResponse response = mvc.perform(
    		  delete("/artist/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as("Check that Artist is retreived.")
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as("Check that Artist Name and ID is filled in.")
      	.isEqualTo("");
  }
}
