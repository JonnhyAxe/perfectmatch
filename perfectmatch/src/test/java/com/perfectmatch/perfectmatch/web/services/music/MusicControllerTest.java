package com.perfectmatch.perfectmatch.web.services.music;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.perfectmatch.PerfectMatchApplication;
import com.perfectmatch.spring.PerfectMatchServletConfig;


@RunWith(SpringRunner.class)

@SpringBootTest

@ContextConfiguration(classes = { PerfectMatchApplication.class, PerfectMatchServletConfig.class  })
//@TestPropertySource(
//		  locations = "classpath:application-h2.properties")
@Ignore //FROM TomCat to Jetty but actually is to Netty		
public class MusicControllerTest {
	

    private final static String URI = "http://localhost:8080/music/Please%20Stop%20(Original%20Mix)";

    
//    @Autowired
//    private TestRestTemplate restTemplate;

    MultiValueMap<String, String> headers = new HttpHeaders() {{
        add("Content-Type", "application/json");
        add("Accept", "application/json");
    }};

//    @Test
//    public void shouldReturn() throws Exception {
//        ResponseEntity<Music> entity = restTemplate.getForEntity("/music/Please%20Stop%20(Original%20Mix)", Music.class);
//        assertThat(entity.getStatusCodeValue(), is(200));
//    }

    // tests

    @Test
    public void whenAllRolesAreRetrieved_then200OK() {

        final RequestSpecification basicAuth = RestAssured.given().auth().preemptive().basic("JAxe", "JAxe123");
        final Response response = basicAuth.accept(ContentType.JSON).get(URI);

        Assert.assertEquals(response.getStatusCode(), Matchers.equalTo(200));
    }
//    
}
