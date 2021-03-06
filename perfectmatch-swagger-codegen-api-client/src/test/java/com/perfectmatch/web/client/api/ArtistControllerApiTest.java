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

import com.perfectmatch.web.client.model.Artist;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ArtistControllerApi
 */
@Ignore
public class ArtistControllerApiTest {

    private final ArtistControllerApi api = new ArtistControllerApi();

    
    /**
     * createArtist
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void createArtistUsingPOSTTest() {
        Artist artist = null;
        Artist response = api.createArtistUsingPOST(artist);

        // TODO: test validations
    }
    
    /**
     * deleteArtistByName
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void deleteArtistByNameUsingDELETETest() {
        String name = null;
        Artist response = api.deleteArtistByNameUsingDELETE(name);

        // TODO: test validations
    }
    
    /**
     * getArtistById
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getArtistByIdUsingGETTest() {
        String id = null;
        Artist response = api.getArtistByIdUsingGET(id);

        // TODO: test validations
    }
    
    /**
     * getArtistByName
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getArtistByNameUsingGETTest() {
        String name = null;
        Artist response = api.getArtistByNameUsingGET(name);

        // TODO: test validations
    }
    
}
