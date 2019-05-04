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
import com.perfectmatch.persistence.model.PerfectMatch;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.services.impl.PerfectMatchServiceBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class PerfectMatchControllerTest {
  private static final String AWESOME_MUSIC_NAME_THIS = "AwesomeMusicNameThis";

  private static final String AWESOME_MUSIC_NAME_THAT = "AwesomeMusicNameThat";

  private static final String CHECK_THAT_PERFECT_MATCH_IS_RETREIVED =
      "Check that perfect match is retrieved";

  private static final String CHECK_THAT_PERFECT_MATCH_FIELDS_ARE_FILLED_IN =
      "Check that erfect match fields are filled in";

  private static final String CHECK_THAT_LIST_CONTENT_IS_CORRECT =
      "Check that list content is correct";

  private static final String CHECK_THAT_PERFECT_MATCHS_ARE_RETREIVED =
      "Check that perfect matchs are retreived";

  private static final String CHECK_THAT_PERFECT_MATCH_DOES_NOT_EXIST =
      "Check that perfect match does not exist";

  private static final String CHECK_THAT_ERROR_MESSAGE_IS_CORRECT =
      "Check that error message is correct";

  private MockMvc mvc;

  @InjectMocks
  private PerfectMatchController perfectMatchController;

  @Mock
  private PerfectMatchServiceBean perfectMatchServiceBean;

  // These object will be magically initialized by the initFields method below.
  private JacksonTester<PerfectMatch> jsonPerfectMatch;
  private JacksonTester<Flux<PerfectMatch>> jsonPerfectMatchs;

  private JacksonTester<ApiError> jsonApiError;


  @Before
  public void setup() {
    // Initializes the JacksonTester
    JacksonTester.initFields(this, new ObjectMapper());
    // MockMvc standalone approach
    mvc = MockMvcBuilders.standaloneSetup(perfectMatchController)
        .setControllerAdvice(new RestResponseEntityExceptionHandler(),
            new PerfectMatchControllerExceptionHandler())
        .build();
  }

  @Test
  public void getAllPerfefctMatchs() throws Exception {
    Flux<PerfectMatch> expectedPerfectMatchs = Flux.just(new PerfectMatch());

    given(perfectMatchServiceBean.findAll()).willReturn(expectedPerfectMatchs);

    // when
    MockHttpServletResponse response =
        mvc.perform(get("/perfect_match").contentType(MediaType.APPLICATION_JSON)).andReturn()
            .getResponse();

    then(response.getStatus()).as(CHECK_THAT_PERFECT_MATCHS_ARE_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(response.getContentAsString()).as(CHECK_THAT_LIST_CONTENT_IS_CORRECT)
        .isEqualTo(jsonPerfectMatchs.write(expectedPerfectMatchs).getJson());
  }

  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
    String matchName = AWESOME_MUSIC_NAME_THIS + "," + AWESOME_MUSIC_NAME_THAT;
    PerfectMatch expectedPerfectMatch = new PerfectMatch();
    expectedPerfectMatch.setName(matchName);


    given(perfectMatchServiceBean.findPerfectMatchByName(matchName))
        .willReturn(Mono.just(expectedPerfectMatch));

    // when
    MockHttpServletResponse response =
        mvc.perform(get("/perfect_match/" + matchName).accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_PERFECT_MATCH_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.OK.value());
    then(response.getContentAsString()).as(CHECK_THAT_PERFECT_MATCH_FIELDS_ARE_FILLED_IN)
        .isEqualTo(jsonPerfectMatch.write(expectedPerfectMatch).getJson());
  }

  @Test
  public void canRetrieveByPerfectMatchNameWhenDoesNotExists() throws Exception {
    String matchName = AWESOME_MUSIC_NAME_THIS + "," + AWESOME_MUSIC_NAME_THAT;

    ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(),
        "Perfect Match not Found for a given name : " + matchName,
        "Perfect Match not Found for a given name : " + matchName);


    // when
    MockHttpServletResponse response =
        mvc.perform(get("/perfect_match/" + matchName).accept(MediaType.APPLICATION_JSON))
            .andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_PERFECT_MATCH_DOES_NOT_EXIST).isNotNull()
        .isEqualTo(HttpStatus.NOT_FOUND.value());
    then(response.getContentAsString()).as(CHECK_THAT_ERROR_MESSAGE_IS_CORRECT)
        .isEqualTo(jsonApiError.write(expectedError).getJson());
  }

  @Test
  public void createPerfectMatch() throws Exception {

    String matchName = AWESOME_MUSIC_NAME_THIS + "," + AWESOME_MUSIC_NAME_THAT;
    PerfectMatch expectedPerfectMatch = new PerfectMatch();
    expectedPerfectMatch.setName(matchName);

    given(perfectMatchServiceBean.save(expectedPerfectMatch))
        .willReturn(Mono.just(expectedPerfectMatch));

    // when
    MockHttpServletResponse response = mvc
        .perform(post("/perfect_match").contentType(MediaType.APPLICATION_JSON)
            .content(jsonPerfectMatch.write(expectedPerfectMatch).getJson()))
        .andReturn().getResponse();

    then(response.getStatus()).as(CHECK_THAT_PERFECT_MATCH_IS_RETREIVED).isNotNull()
        .isEqualTo(HttpStatus.CREATED.value());
    then(response.getContentAsString()).as(CHECK_THAT_PERFECT_MATCH_FIELDS_ARE_FILLED_IN)
        .isEqualTo(jsonPerfectMatch.write(expectedPerfectMatch).getJson());

  }

}
