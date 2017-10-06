package com.perfectmatch.perfectmatch.web.services.music;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.perfectmatch.perfectmatch.spring.PerfectMatchLiveTestConfig;
/**
 *
 *
 */
@ActiveProfiles({ "test" })
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        PerfectMatchLiveTestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class MusicBasicLiveTest {

    private final static String URI = "http://localhost:8080/music/Please%20Stop%20(Original%20Mix)";

    // tests

    @Test
    public void whenAllRolesAreRetrieved_then200OK() {

        final RequestSpecification basicAuth = RestAssured.given().auth().preemptive().basic("JAxe", "JAxe123");
        final Response response = basicAuth.accept(ContentType.JSON).get(URI);

        assertEquals(response.getStatusCode(), Matchers.equalTo(200));
    }

}
