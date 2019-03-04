package com.perfectmatch.perfectmatch.persistence.dao.feature;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.perfectmatch.web.client.api.ArtistControllerApi;
import com.perfectmatch.web.client.api.MusicControllerApi;

@Configuration
public class IntegrationSwaggerAPI {

	@Bean
	ArtistControllerApi artistControllerApi() {
		return new ArtistControllerApi();
	}
	
	@Bean
	MusicControllerApi musicControllerApi() {
		return new MusicControllerApi();
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}
