package com.perfectmatch.web.controller;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.services.AdderService;

import net.thucydides.core.annotations.Step;

@Component
public class ArtistRestSteps {
	
	  private static final String AWESOME_ARTIST_NAME = "AwesomeArtistName";

	  private static final String CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN = "Check that Artist Name and ID is filled in.";

	  private static final String CHECK_THAT_ARTIST_IS_RETREIVED = "Check that Artist is retreived.";

	  private static final String CHECK_THAT_ARTIST_DOES_NOT_EXIST = "Check that Artist does not exist.";

	  private static final String CHECK_THAT_ERROR_MESSAGE = "Check that error message";

	  private MockMvc mvc;
	  private MockHttpServletResponse response;
	  private Artist expectedArtist;
	  
	    @Step("Given an artist with name '{0}' and id '{1}'" )
	    public void givenTheArtist(String name, String id) throws UnsupportedEncodingException {
	    	expectedArtist = Artist.builder()
					.id(id).name(name)
					.build();
	    }
	 
	    @Step("When creating artist")
	    public void whenCreateTheArtist(JacksonTester<Artist> jsonArtist) throws IOException, Exception {
	        response = mvc.perform(
	                post("/artist")
	                	.contentType(MediaType.APPLICATION_JSON)
	                	.content(jsonArtist.write(expectedArtist).getJson()
	                  )
	                ).andReturn().getResponse();

	    }
	    
	    @Step("got the artists created")
	    public void thenTheArtistIsCreated(String name, JacksonTester<Artist> jsonArtist) throws UnsupportedEncodingException, IOException {
	    	 then(response.getStatus())
	       	.as(CHECK_THAT_ARTIST_IS_RETREIVED)
	       	.isNotNull()
	       	.isEqualTo(HttpStatus.CREATED.value());
//	       then(response.getContentAsString())
//	       	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
//	       	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
	    }
	 
	    @Step("got the artists created with name '{0}'")
	    public void thenTheArtistIsCreatedCorretly(String name, JacksonTester<Artist> jsonArtist) throws UnsupportedEncodingException, IOException {
//	       then(response.getContentAsString())
//	       	.as(CHECK_THAT_ARTIST_NAME_AND_ID_IS_FILLED_IN)
//	       	.isEqualTo(jsonArtist.write(expectedArtist).getJson());
	    }

		public void setMockMvc(MockMvc mvc) {
			this.mvc = mvc;
		}
}
