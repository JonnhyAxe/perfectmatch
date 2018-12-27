package com.perfectmatch.web.controller;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.services.impl.ArtistServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class ArtistControllerTest {
  
  private static final String AWESOME_ARTIST_NAME = "AwesomeArtistName";

  private static final String CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN = "Check that Artist Name and ID is filled in.";

  private static final String CHECK_THAT_ARTIST_IS_RETREIVED = "Check that Artist is retreived.";

  private static final String CHECK_THAT_ARTIST_DOES_NOT_EXIST = "Check that Artist does not exist.";

  private static final String CHECK_THAT_ERROR_MESSAGE = "Check that error message";

  private MockMvc mvc;
  
  @InjectMocks private ArtistController artistController;

  @Mock private ArtistServiceBean artistService;

  // These object will be magically initialized by the initFields method below.
  private JacksonTester<Artist> 	jsonArtist;
  private JacksonTester<ApiError> 	jsonApiError;

  @Before
  public void setup() {
      // Initializes the JacksonTester
      JacksonTester.initFields(this, new ObjectMapper());
      // MockMvc standalone approach
      mvc = MockMvcBuilders.standaloneSetup(artistController)
              .setControllerAdvice(new RestResponseEntityExceptionHandler(),
            		  new ArtistControllerExceptionHandler()
            		  )
//              .addFilters(new Artist())
              .build();
  }
  
  @Test
  public void canCreateArtist() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_ARTIST_NAME);
	 
      given(artistService.createArtist(expectedArtist))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              post("/artist")
              	.contentType(MediaType.APPLICATION_JSON)
              	.content(jsonArtist.write(expectedArtist).getJson()
                )
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.CREATED.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }
  
  
  @Test
  public void cannotCreateArtistWihthoutName() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName(null);

      // when
      MockHttpServletResponse response = mvc.perform(
              post("/artist")
              	.contentType(MediaType.APPLICATION_JSON)
              	.content(jsonArtist.write(expectedArtist).getJson()
                )
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.BAD_REQUEST.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
      	.contains("Field error in object 'artist' on field 'name': rejected value [null]");
  }
  
  @Test
  public void canRetrieveByIdWhenExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  String id = "2";
	  expectedArtist.setId(id);
	  expectedArtist.setName(AWESOME_ARTIST_NAME);
	 
      given(artistService.getArtistById(id))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/id/" + id)
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByIdWhenDoesNotExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  String ID = "2";
	  expectedArtist.setId(ID);
	  expectedArtist.setName(AWESOME_ARTIST_NAME);
	 
      ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(), 
    		  "Artist not found for the given id : 0", 
    		  "Artist not found for the given id : 0");
	  
      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/id/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
      	.isNotNull()
     	.isEqualTo(HttpStatus.NOT_FOUND.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
    	.isEqualTo(jsonApiError.write(expectedError).getJson());
  }
 
  
  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_ARTIST_NAME);
	 
      given(artistService.getArtistByName(AWESOME_ARTIST_NAME))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/"+ AWESOME_ARTIST_NAME)
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByNameWhenDoesNotExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_ARTIST_NAME);


      ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(), 
    		  "Artist not found for the given name : 0", 
    		  "Artist not found for the given name : 0");
	  

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/artist/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_DOES_NOT_EXIST)
      	.isNotNull()
      	.isEqualTo(HttpStatus.NOT_FOUND.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ERROR_MESSAGE)
      	.isEqualTo(jsonApiError.write(expectedError).getJson());
  }
  
  @Test
  public void canDeleteByNameWhenExists() throws Exception {
	  String artistName = AWESOME_ARTIST_NAME;
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName(artistName);
	 
      given(artistService.deleteArtistByName(artistName))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              delete("/artist/AwesomeArtistName")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
      	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }
  
  @Test
  public void canDeleteByNameWhenDoesNotExists() throws Exception {
	  Artist expectedArtist = new Artist();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_ARTIST_NAME);
	 
      ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(), 
    		  "Artist not found for the given name : 0", 
    		  "Artist not found for the given name : 0");
	  

      // when
      MockHttpServletResponse response = mvc.perform(
    		  delete("/artist/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_ARTIST_DOES_NOT_EXIST)
      	.isNotNull()
      	.isEqualTo(HttpStatus.NOT_FOUND.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ERROR_MESSAGE)
      	.isEqualTo(jsonApiError.write(expectedError).getJson());
  }
}
