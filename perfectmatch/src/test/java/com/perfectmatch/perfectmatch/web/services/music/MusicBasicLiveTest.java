package com.perfectmatch.perfectmatch.web.services.music;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.perfectmatch.PerfectMatchApplication;
import com.perfectmatch.perfectmatch.spring.PerfectMatchLiveTestConfig;
/**
 *
 *
 */
//TODO: change this tests to a different module OR Active Profile
//@ActiveProfiles({ "test" })
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PerfectMatchApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class MusicBasicLiveTest {

	//TODO: RANDOM_PORT
    private final static String URI = "http://localhost:8080/music/Please%20Stop%20(Original%20Mix)";


    @Test
    public void whenAllRolesAreRetrieved_then200OK() {

    	//change this using command line
        final RequestSpecification basicAuth = RestAssured.given().auth().preemptive().basic("JAxe", "JAxe123");
        final Response response = basicAuth.accept(ContentType.JSON).get(URI);

        assertEquals(response.getStatusCode(), Matchers.equalTo(200));
    }

}
