package com.perfectmatch.web.controller;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

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
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.persistence.model.Style;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.services.impl.MusicServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class MusicControllerTest {

 private static final String AWESOME_MUSIC_NAME = "AwesomeMusicName";
 
 private static final String CHECK_THAT_MUSIC_IS_RETREIVED = "Check that music is retrieved";
 
 private static final String CHECK_THAT_MUSIC_NAME_AND_ID_IS_FILLED_IN = "Check that music name and id is filled in";
 
 private static final String CHECK_THAT_LIST_CONTENT_IS_CORRECT = "Check that list content is correct";

 private static final String CHECK_THAT_MUSICS_ARE_RETREIVED = "Check that musics are retreived";

 private static final String CHECK_THAT_MUSIC_DOES_NOT_EXIST = "Check that music does not exist";
 
 private static final String CHECK_THAT_ERROR_MESSAGE_IS_CORRECT = "Check that error message is correct";
 
 private MockMvc mvc;
	  
 @InjectMocks private MusicController musicController;

 @Mock private MusicServiceBean musicService;

  // These object will be magically initialized by the initFields method below.
  private JacksonTester<Music> 	jsonMusic;
  private JacksonTester<List<Music>>  jsonMusics;
  private JacksonTester<ApiError> 	jsonApiError;
  
  @Before
  public void setup() {
      // Initializes the JacksonTester
      JacksonTester.initFields(this, new ObjectMapper());
      // MockMvc standalone approach
      mvc = MockMvcBuilders.standaloneSetup(musicController)
              .setControllerAdvice(new RestResponseEntityExceptionHandler(),
            		  new MusicControllerExceptionHandler()
            		  )
              .build();
  }
  
  @Test
  public void getAllMusics() throws Exception {
	  List<Music> expectedMusics = Arrays.asList(new Music());
	 
      given(musicService.findAll())
        .willReturn(Arrays.asList(new Music()));

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/music")
              	.contentType(MediaType.APPLICATION_JSON)
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_MUSICS_ARE_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_LIST_CONTENT_IS_CORRECT)
      	.isEqualTo(jsonMusics.write(expectedMusics).getJson());
  }
  
  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
	  Music expectedArtist = new Music();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_MUSIC_NAME);
	 
      given(musicService.findByName(AWESOME_MUSIC_NAME))
        .willReturn(expectedArtist);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/music/"+ AWESOME_MUSIC_NAME)
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_MUSIC_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_MUSIC_NAME_AND_ID_IS_FILLED_IN)
      	.isEqualTo(jsonMusic.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByNameWhenDoesNotExists() throws Exception {
	  Music expectedArtist = new Music();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_MUSIC_NAME);

      ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(), 
    		  "Music not found for the given name : 0", 
    		  "Music not found for the given name : 0");
	  

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/music/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_MUSIC_DOES_NOT_EXIST)
      	.isNotNull()
      	.isEqualTo(HttpStatus.NOT_FOUND.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ERROR_MESSAGE_IS_CORRECT)
      	.isEqualTo(jsonApiError.write(expectedError).getJson());
  }
  
  
  @Test
  public void cannotCreateArtistWihthoutName() throws Exception {
	  Music expectedArtist = new Music();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_MUSIC_NAME);

      // when
      MockHttpServletResponse response = mvc.perform(
              post("/music")
              	.contentType(MediaType.APPLICATION_JSON)
              	.content(jsonMusic.write(expectedArtist).getJson()
                )
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_MUSIC_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.BAD_REQUEST.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_MUSIC_NAME_AND_ID_IS_FILLED_IN)
      	.contains("Field error in object 'music' on field 'artists': rejected value [null]")
      	.contains("Field error in object 'music' on field 'location': rejected value [null]")
      	.contains("Field error in object 'music' on field 'key': rejected value [null]")
      	.contains("Field error in object 'music' on field 'style': rejected value [null]")
      	.contains("Field error in object 'music' on field 'energy': rejected value [null]")
        .contains("Field error in object 'music' on field 'tempo': rejected value [null]");	  
      
  }
  
  @Test
  public void saveArtist() throws Exception {
	  
      String fileName = "Jansons&Senzala-JNZ.mp3";
	  ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	  URL fileLocation = classloader.getResource(fileName);
	  Music expectedArtist = new Music();
	  expectedArtist.setArtists(Arrays.asList("AwesomeArtistName"));
	  expectedArtist.setName(AWESOME_MUSIC_NAME);
	  expectedArtist.setLocation(fileLocation);
	  expectedArtist.setKey("AwesomeMusicKey");
	  expectedArtist.setStyle(Style.TECH_HOUSE.name());
	  expectedArtist.setEnergy("10");
	  expectedArtist.setTempo("145");
	  
      given(musicService.save(expectedArtist))
       .willReturn(expectedArtist);
	  
      // when
      MockHttpServletResponse response = mvc.perform(
              post("/music")
              	.contentType(MediaType.APPLICATION_JSON)
              	.content(jsonMusic.write(expectedArtist).getJson()
                )
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_MUSIC_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.CREATED.value());
      then(jsonMusic.parseObject(response.getContentAsString()))
      .as(CHECK_THAT_MUSIC_NAME_AND_ID_IS_FILLED_IN)
      .isEqualToComparingOnlyGivenFields(expectedArtist, "artists")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "name") 
      .isEqualToComparingOnlyGivenFields(expectedArtist, "key")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "style")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "energy")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "tempo");
      
  }
  
  @Test
  public void updateArtist() throws Exception {
	  
	  Music expectedArtist = new Music();
	  expectedArtist.getRemixers().addAll(Arrays.asList("AwesomeArtistName"));
	  expectedArtist.setRecordLabel("AwesomeRecordLabel");
	  expectedArtist.setKey("AwesomeMusicKey");
	  expectedArtist.setStyle(Style.TECH_HOUSE.name());
	  expectedArtist.setEnergy("9");
	  expectedArtist.setTempo("145");
	  
      given(musicService.updateMusic(expectedArtist))
       .willReturn(expectedArtist);
	  
      // when
      MockHttpServletResponse response = mvc.perform(
              put("/music")
              	.contentType(MediaType.APPLICATION_JSON)
              	.content(jsonMusic.write(expectedArtist).getJson()
                )
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_MUSIC_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.CREATED.value());
      then(jsonMusic.parseObject(response.getContentAsString()))
      .as(CHECK_THAT_MUSIC_NAME_AND_ID_IS_FILLED_IN)
      .isEqualToComparingOnlyGivenFields(expectedArtist, "remixers")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "recordLabel") 
      .isEqualToComparingOnlyGivenFields(expectedArtist, "key")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "style")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "energy")
      .isEqualToComparingOnlyGivenFields(expectedArtist, "tempo");
      
  }
  
}
