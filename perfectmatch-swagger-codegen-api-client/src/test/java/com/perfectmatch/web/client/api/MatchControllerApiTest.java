/*
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.perfectmatch.web.client.api;

import com.perfectmatch.web.client.model.Match;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for MatchControllerApi
 */
@Ignore
public class MatchControllerApiTest {

    private final MatchControllerApi api = new MatchControllerApi();

    
    /**
     * createMatch
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createMatchUsingPOSTTest() {
        Match resource = null;
        Match response = api.createMatchUsingPOST(resource);

        // TODO: test validations
    }
    
    /**
     * Find all Matchs by music name - without pagination
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findAllMatchByMusicUsingGETTest() {
        String music = null;
        List<Match> response = api.findAllMatchByMusicUsingGET(music);

        // TODO: test validations
    }
    
    /**
     * Find all Matchs - without pagination
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findAllMatchsUsingGETTest() {
        List<Match> response = api.findAllMatchsUsingGET();

        // TODO: test validations
    }
    
    /**
     * Find Match by music pair - without pagination
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void findMatchByMusicPairUsingGETTest() {
        String music = null;
        String music2 = null;
        Match response = api.findMatchByMusicPairUsingGET(music, music2);

        // TODO: test validations
    }
    
}
