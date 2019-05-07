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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.services.impl.ArtistServiceBean;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class ArtistControllerTest {
  // TODO: https://www.sudoinit5.com/post/spring-boot-testing-producer/
  private static final String AWESOME_ARTIST_NAME = "AwesomeArtistName";

  private static final String CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN =
      "Check that Artist Name and ID is filled in.";

  private static final String CHECK_THAT_ARTIST_IS_RETREIVED = "Check that Artist is retreived.";

  private static final String CHECK_THAT_ARTIST_DOES_NOT_EXIST =
      "Check that Artist does not exist.";

  private static final String CHECK_THAT_ERROR_MESSAGE = "Check that error message";

  private MockMvc mvc;

  @InjectMocks
  private ArtistController artistController;

  @Mock
  private ArtistServiceBean artistService;

  // These object will be magically initialized by the initFields method below.
  private JacksonTester<Artist> jsonArtist;
  private JacksonTester<ApiError> jsonApiError;

  @Before
  public void setup() {
    // Initializes the JacksonTester
    JacksonTester.initFields(this, new ObjectMapper());
    // MockMvc standalone approach
    mvc = MockMvcBuilders.standaloneSetup(artistController)
        .setControllerAdvice(new RestResponseEntityExceptionHandler(),
            new ArtistControllerExceptionHandler())
        // .addFilters(new Artist())
        .build();
  }

  @Test
  public void canCreateArtist() throws Exception {
    Artist expectedArtist = Artist.builder().id("2").name(AWESOME_ARTIST_NAME).build();

    given(artistService.createArtist(expectedArtist)).willReturn(Mono.just(expectedArtist));

    // when
    final MvcResult response = mvc.perform(post("/artist").contentType(MediaType.APPLICATION_JSON)
        .content(jsonArtist.write(expectedArtist).getJson())).andReturn();

    final MvcResult ayncResponse =
        mvc.perform(MockMvcRequestBuilders.asyncDispatch(response)).andReturn();


    MockHttpServletResponse httpResponse = ayncResponse.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.CREATED.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
        .isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }


  @Test
  public void cannotCreateArtistWihthoutName() throws Exception {
    Artist expectedArtist = Artist.builder().id("2").name(null).build();

    // when
    MvcResult response = mvc.perform(post("/artist").contentType(MediaType.APPLICATION_JSON)
        .content(jsonArtist.write(expectedArtist).getJson())).andReturn();

    // Then
    MockHttpServletResponse httpResponse = response.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.BAD_REQUEST.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
        .contains("Field error in object 'artist' on field 'name': rejected value [null]");
  }

  @Test
  public void canRetrieveByIdWhenExists() throws Exception {
    String id = "2";
    Artist expectedArtist = Artist.builder().id(id).name(AWESOME_ARTIST_NAME).build();

    given(artistService.getArtistById(id)).willReturn(Mono.just(expectedArtist));

    // when
    MvcResult response =
        mvc.perform(get("/artist/id/" + id).accept(MediaType.APPLICATION_JSON)).andReturn();

    // TODO: what is the difference in case of failure? what error messages...
    final MvcResult ayncResponse = mvc.perform(MockMvcRequestBuilders.asyncDispatch(response))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.header().string("Content-Type",
            MediaType.APPLICATION_JSON_UTF8_VALUE))
        .andExpect(
            MockMvcResultMatchers.content().string(jsonArtist.write(expectedArtist).getJson()))
        .andReturn();

    // Then
    MockHttpServletResponse httpResponse = ayncResponse.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
        .isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByIdWhenDoesNotExists() throws Exception {

    ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(),
        "Artist not found for the given id : 0", "Artist not found for the given id : 0");


    given(artistService.getArtistById("0")).willReturn(Mono.empty());

    // when
    final MvcResult response =
        mvc.perform(get("/artist/id/0").accept(MediaType.APPLICATION_JSON)).andReturn();
    final MvcResult ayncResponse =
        mvc.perform(MockMvcRequestBuilders.asyncDispatch(response)).andReturn();

    // then
    MockHttpServletResponse httpResponse = ayncResponse.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.NOT_FOUND.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
        .isEqualTo(jsonApiError.write(expectedError).getJson());
  }


  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
    Artist expectedArtist = Artist.builder().id("2").name(AWESOME_ARTIST_NAME).build();

    given(artistService.getArtistByName(AWESOME_ARTIST_NAME)).willReturn(Mono.just(expectedArtist));

    // when
    final MvcResult response =
        mvc.perform(get("/artist/" + AWESOME_ARTIST_NAME).accept(MediaType.APPLICATION_JSON))
            .andReturn();

    final MvcResult ayncResponse =
        mvc.perform(MockMvcRequestBuilders.asyncDispatch(response)).andReturn();

    MockHttpServletResponse httpResponse = ayncResponse.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
        .isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canRetrieveByNameWhenDoesNotExists() throws Exception {

    ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(),
        "Artist not found for the given name : 0", "Artist not found for the given name : 0");

    given(artistService.getArtistByName("0")).willReturn(Mono.empty());

    // when
    final MvcResult response =
        mvc.perform(get("/artist/0").accept(MediaType.APPLICATION_JSON)).andReturn();

    final MvcResult ayncResponse =
        mvc.perform(MockMvcRequestBuilders.asyncDispatch(response)).andReturn();

    MockHttpServletResponse httpResponse = ayncResponse.getResponse();

    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_DOES_NOT_EXIST).isNotNull()
        .isEqualTo(HttpStatus.NOT_FOUND.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ERROR_MESSAGE)
        .isEqualTo(jsonApiError.write(expectedError).getJson());
  }

  @Test
  public void canDeleteByNameWhenExists() throws Exception {
    String artistName = AWESOME_ARTIST_NAME;
    Artist expectedArtist = Artist.builder().id("2").name(AWESOME_ARTIST_NAME).build();;

    given(artistService.deleteArtistByName(artistName)).willReturn(Mono.just(expectedArtist));

    // when
    MvcResult response =
        mvc.perform(delete("/artist/AwesomeArtistName").accept(MediaType.APPLICATION_JSON))
            .andReturn();

    final MvcResult ayncResponse =
        mvc.perform(MockMvcRequestBuilders.asyncDispatch(response)).andReturn();

    MockHttpServletResponse httpResponse = ayncResponse.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
        .isEqualTo(jsonArtist.write(expectedArtist).getJson());
  }

  @Test
  public void canDeleteByNameWhenDoesNotExists() throws Exception {

    ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(),
        "Artist not found for the given name : 0", "Artist not found for the given name : 0");

    String artistName = "0";
    given(artistService.deleteArtistByName(artistName)).willReturn(Mono.empty());

    // when
    final MvcResult response =
        mvc.perform(delete("/artist/0").accept(MediaType.APPLICATION_JSON)).andReturn();

    final MvcResult ayncResponse =
        mvc.perform(MockMvcRequestBuilders.asyncDispatch(response)).andReturn();

    MockHttpServletResponse httpResponse = ayncResponse.getResponse();
    then(httpResponse.getStatus()).as(CHECK_THAT_ARTIST_DOES_NOT_EXIST).isNotNull()
        .isEqualTo(HttpStatus.NOT_FOUND.value());
    then(httpResponse.getContentAsString()).as(CHECK_THAT_ERROR_MESSAGE)
        .isEqualTo(jsonApiError.write(expectedError).getJson());
  }


}
