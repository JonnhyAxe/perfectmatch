package com.perfectmatch.web.controller;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import com.perfectmatch.persistence.model.Sample;
import com.perfectmatch.web.RestResponseEntityExceptionHandler;
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.services.impl.SampleServiceBean;

@RunWith(MockitoJUnitRunner.class)
public class SampleControllerTest {

	 private static final String AWESOME_SAMPLE_NAME = "AwesomeSampleName";
	 
	 private static final String CHECK_THAT_SAMPLE_IS_RETREIVED = "Check that sample is retrieved";
	 
	 private static final String CHECK_THAT_SAMPLE_NAME_AND_ID_IS_FILLED_IN = "Check that sample name and id is filled in";
	 
	 private static final String CHECK_THAT_LIST_CONTENT_IS_CORRECT = "Check that list content is correct";

	 private static final String CHECK_THAT_SAMPLES_ARE_RETREIVED = "Check that samples are retrieved";

	 private static final String CHECK_THAT_SAMPLE_DOES_NOT_EXIST = "Check that sample does not exist";
	 
	 private static final String CHECK_THAT_ERROR_MESSAGE_IS_CORRECT = "Check that error message is correct";
	 
	 private MockMvc mvc;
		  
	 @InjectMocks private SampleController sampleController;

	 @Mock private SampleServiceBean sampleService;
	 
	 // These object will be magically initialized by the initFields method below.
	 private JacksonTester<Sample> jsonSample;
	 private JacksonTester<List<Sample>> jsonSamples; 
	 private JacksonTester<ApiError> 	jsonApiError;

	 @Before
	 public void setup() {
      // Initializes the JacksonTester
      JacksonTester.initFields(this, new ObjectMapper());
      // MockMvc standalone approach
      mvc = MockMvcBuilders.standaloneSetup(sampleController)
              .setControllerAdvice(new RestResponseEntityExceptionHandler(),
            		  new SampleControllerExceptionHandler()
            		  )
              .build();
	 }
  
  @Test
  public void getAllSamples() throws Exception {
	  List<Sample> expectedSamples = Arrays.asList(new Sample());
	 
      given(sampleService.findAll())
        .willReturn(expectedSamples);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/sample")
              	.contentType(MediaType.APPLICATION_JSON)
              ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_SAMPLES_ARE_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_LIST_CONTENT_IS_CORRECT)
      	.isEqualTo(jsonSamples.write(expectedSamples).getJson());
  }
  
  @Test
  public void canRetrieveByNameWhenExists() throws Exception {
      String fileName = "Jansons&Senzala-JNZ.mp3";
	  ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	  URL fileLocation = classloader.getResource(fileName);
	  Sample expectedSample = new Sample();
	  expectedSample.setId("2");
	  expectedSample.setName(AWESOME_SAMPLE_NAME);
	  expectedSample.setTimestamp(141243);
	  expectedSample.setLocation(fileLocation);
	  
      given(sampleService.findByName(AWESOME_SAMPLE_NAME))
        .willReturn(expectedSample);

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/sample/"+ AWESOME_SAMPLE_NAME)
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_SAMPLE_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.OK.value());

      then(jsonSample.parseObject(response.getContentAsString()))
        .as(CHECK_THAT_SAMPLE_NAME_AND_ID_IS_FILLED_IN)
        .isEqualToComparingOnlyGivenFields(expectedSample, "name")
        .isEqualToComparingOnlyGivenFields(expectedSample, "timestamp") 
        .isEqualToComparingOnlyGivenFields(expectedSample, "location");
  }

  @Test
  public void canRetrieveByNameWhenDoesNotExists() throws Exception {
	  Music expectedArtist = new Music();
	  expectedArtist.setId("2");
	  expectedArtist.setName(AWESOME_SAMPLE_NAME);

      ApiError expectedError = new ApiError(HttpStatus.NOT_FOUND.value(), 
    		  "Sample not found for the given name : 0", 
    		  "Sample not found for the given name : 0");
	  

      // when
      MockHttpServletResponse response = mvc.perform(
              get("/sample/0")
              	.accept(MediaType.APPLICATION_JSON)
              )
              .andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_SAMPLE_DOES_NOT_EXIST)
      	.isNotNull()
      	.isEqualTo(HttpStatus.NOT_FOUND.value());
      then(response.getContentAsString())
      	.as(CHECK_THAT_ERROR_MESSAGE_IS_CORRECT)
      	.isEqualTo(jsonApiError.write(expectedError).getJson());
  } 
  
  @Test
  public void saveSample() throws Exception {
	  String fileName = "Jansons&Senzala-JNZ.mp3";
	  ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	  URL fileLocation = classloader.getResource(fileName);
	  Sample expectedSample = new Sample();
	  expectedSample.setId("2");
	  expectedSample.setName(AWESOME_SAMPLE_NAME);
	  expectedSample.setTimestamp(141243);
	  expectedSample.setLocation(fileLocation);
	  
      given(sampleService.save(expectedSample))
        .willReturn(expectedSample);

      // when
      MockHttpServletResponse response = mvc.perform(
    		  post("/sample")
            	.contentType(MediaType.APPLICATION_JSON)
            	.content(jsonSample.write(expectedSample).getJson())
    		  ).andReturn().getResponse();

      then(response.getStatus())
      	.as(CHECK_THAT_SAMPLE_IS_RETREIVED)
      	.isNotNull()
      	.isEqualTo(HttpStatus.CREATED.value());

      then(jsonSample.parseObject(response.getContentAsString()))
        .as(CHECK_THAT_SAMPLE_NAME_AND_ID_IS_FILLED_IN)
        .isEqualToComparingOnlyGivenFields(expectedSample, "id")
        .isEqualToComparingOnlyGivenFields(expectedSample, "name")
        .isEqualToComparingOnlyGivenFields(expectedSample, "timestamp") 
        .isEqualToComparingOnlyGivenFields(expectedSample, "location");
      
  }
}
