package com.perfectmatch.web.services.music;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.perfectmatch.persistence.dao.MusicRepository;
import com.perfectmatch.persistence.model.Music;


@RunWith(SpringRunner.class)

@SpringBootTest
public class MusicControllerTest {
	

    private final static String URI = "/music/Please%20Stop%20(Original%20Mix)";
 
    @Autowired
    private MusicRepository musicJpaRepository;

	private List<Music> expectedMusic;

	private WebTestClient webTestClient;
	
    @Before
	public void setup() {
		webTestClient = WebTestClient.bindToServer()
		         .baseUrl("http://localhost:"+ 8081)
		         .build();
		
		expectedMusic = musicJpaRepository.findAll();

	}
    

    @Test
    public void whenAllRolesAreRetrieved_then200OK() {

        this.webTestClient
        .get().uri(URI)
		.exchange()
		.expectStatus().isOk(); //TODO: why NO CONTENT???
//		.expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8);
		//.expectBodyList(BlogPost.class).isEqualTo(expectedBlogPosts);


    }
//    
}
