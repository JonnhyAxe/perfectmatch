package com.perfectmatch.web.controller;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
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
import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.persistence.model.MatchRule;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.exception.ApiError;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class MatchControllerTest {

  private static final String AWESOME_MUSIC_NAME_THIS = "AwesomeMusicNameThis";

  private static final String AWESOME_MUSIC_NAME_THAT = "AwesomeMusicNameThat";

  private static final String AWESOME_MUSIC_NAME_THAT2 = "AwesomeMusicNameThat2";

  private static final String CHECK_THAT_MATCH_IS_RETREIVED = "Check that match is retrieved";

  private static final String CHECK_THAT_MATCH_FIELDS_ARE_FILLED_IN =
      "Check that Match fields are filled in";

  private static final String CHECK_THAT_LIST_CONTENT_IS_CORRECT =
      "Check that list content is correct";

  private static final String CHECK_THAT_MATCHS_ARE_RETREIVED = "Check that matchs are retreived";

  private static final String CHECK_THAT_MATCH_DOES_NOT_EXIST = "Check that match does not exist";

  private static final String CHECK_THAT_ERROR_MESSAGE_IS_CORRECT =
      "Check that error message is correct";

  private MockMvc mvc;

  @InjectMocks
  private MatchController matchController;

  @Mock
  private SampleMatchRepository sampleMatchRepository;

  // These object will be magically initialized by the initFields method below.
  private JacksonTester<Match> jsonMatch;
  private JacksonTester<Flux<Match>> jsonMatchs;
  private JacksonTester<ApiError> jsonApiError;

  @Before
  public void setup() {
    // Initializes the JacksonTester
    JacksonTester.initFields(this, new ObjectMapper());
    // MockMvc standalone approach
    mvc = MockMvcBuilders.standaloneSetup(matchController).setControllerAdvice(
        new RestResponseEntityExceptionHandler(), new MatchControllerExceptionHandler()).build();
  }

  @Test
  public void getAllMatchs() throws Exception {
    Flux<Match> expectedMatchs = Flux.just(new Match());

    given(sampleMatchRepository.findAll()).willReturn(expectedMatchs);

    // when
    MockHttpServletResponse response = mvc
        .perform(get("/match").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCHS_ARE_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(response.getContentAsString()).as(CHECK_THAT_LIST_CONTENT_IS_CORRECT)
        .isEqualTo(jsonMatchs.write(expectedMatchs).getJson());
  }

  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThis(AWESOME_MUSIC_NAME_THIS);
    expectedMatch.setMusicNameThat(AWESOME_MUSIC_NAME_THAT);
    expectedMatch.setRule(MatchRule.DEFAULT.name());

    given(sampleMatchRepository.findMatchByMusics(AWESOME_MUSIC_NAME_THIS, AWESOME_MUSIC_NAME_THAT))
        .willReturn(Mono.just(expectedMatch));

    // when
    MockHttpServletResponse response =
        mvc.perform(get("/match/" + AWESOME_MUSIC_NAME_THIS + "/" + AWESOME_MUSIC_NAME_THAT)
            .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCH_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(response.getContentAsString()).as(CHECK_THAT_MATCH_FIELDS_ARE_FILLED_IN)
        .isEqualTo(jsonMatch.write(expectedMatch).getJson());
  }

  @Test
  public void canRetrieveByNameWhenExistsNamesInversed() throws Exception {
    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThis(AWESOME_MUSIC_NAME_THAT);
    expectedMatch.setMusicNameThat(AWESOME_MUSIC_NAME_THIS);
    expectedMatch.setRule(MatchRule.DEFAULT.name());

    given(sampleMatchRepository.findMatchByMusics(AWESOME_MUSIC_NAME_THAT, AWESOME_MUSIC_NAME_THIS))
        .willReturn(Mono.just(expectedMatch));

    // when
    MockHttpServletResponse response =
        mvc.perform(get("/match/" + AWESOME_MUSIC_NAME_THAT + "/" + AWESOME_MUSIC_NAME_THIS)
            .accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCH_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(response.getContentAsString()).as(CHECK_THAT_MATCH_FIELDS_ARE_FILLED_IN)
        .isEqualTo(jsonMatch.write(expectedMatch).getJson());
  }

  @Test
  public void canRetrieveByNameWhenDoesNotExists() throws Exception {
    ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(),
        "Match not found for given music names : " + "fakeMusicName1" + ", " + "fakeMusicName2",
        "Match not found for given music names : " + "fakeMusicName1" + ", " + "fakeMusicName2");


    // when
    MockHttpServletResponse response =
        mvc.perform(get("/match/fakeMusicName1/fakeMusicName2").accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCH_DOES_NOT_EXIST).isNotNull()
        .isEqualTo(HttpStatus.NOT_FOUND.value());
    then(response.getContentAsString()).as(CHECK_THAT_ERROR_MESSAGE_IS_CORRECT)
        .isEqualTo(jsonApiError.write(expectedError).getJson());
  }

  @Test
  public void findAllMatchByMusic() throws Exception {
    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThis(AWESOME_MUSIC_NAME_THIS);
    expectedMatch.setMusicNameThat(AWESOME_MUSIC_NAME_THAT);

    Match expectedMatch2 = new Match();
    expectedMatch.setMusicNameThis(AWESOME_MUSIC_NAME_THIS);
    expectedMatch.setMusicNameThat(AWESOME_MUSIC_NAME_THAT2);

    Flux<Match> expectedListMatchs = Flux.just(expectedMatch, expectedMatch2);

    given(sampleMatchRepository.findAllBymusicName(AWESOME_MUSIC_NAME_THIS))
        .willReturn(expectedListMatchs);


    // when
    MockHttpServletResponse response =
        mvc.perform(get("/match/" + AWESOME_MUSIC_NAME_THIS).accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCH_DOES_NOT_EXIST).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(response.getContentAsString()).as(CHECK_THAT_MATCH_FIELDS_ARE_FILLED_IN)
        .isEqualTo(jsonMatchs.write(expectedListMatchs).getJson());
  }

  @Test
  public void findAllMatchByMusicNotFound() throws Exception {
    ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(),
        "Match not found for given music name : " + AWESOME_MUSIC_NAME_THIS,
        "Match not found for given music name : " + AWESOME_MUSIC_NAME_THIS);



    // when
    MockHttpServletResponse response =
        mvc.perform(get("/match/" + AWESOME_MUSIC_NAME_THIS).accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCH_DOES_NOT_EXIST).isNotNull()
        .isEqualTo(HttpStatus.NOT_FOUND.value());
    then(response.getContentAsString()).as(CHECK_THAT_ERROR_MESSAGE_IS_CORRECT)
        .isEqualTo(jsonApiError.write(expectedError).getJson());
  }


  @Test
  public void createMatch() throws Exception {

    Match expectedMatch = new Match();
    expectedMatch.setMusicNameThis(AWESOME_MUSIC_NAME_THIS);
    expectedMatch.setMusicNameThat(AWESOME_MUSIC_NAME_THAT);
    expectedMatch.setRule(MatchRule.DEFAULT.name());

    given(sampleMatchRepository.save(expectedMatch)).willReturn(Mono.just(expectedMatch));

    // when
    MockHttpServletResponse response =
        mvc.perform(post("/match").contentType(MediaType.APPLICATION_JSON)
            .content(jsonMatch.write(expectedMatch).getJson())).andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_MATCH_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.CREATED.value());
    then(response.getContentAsString()).as(CHECK_THAT_MATCH_FIELDS_ARE_FILLED_IN)
        .isEqualTo(jsonMatch.write(expectedMatch).getJson());

  }
}
