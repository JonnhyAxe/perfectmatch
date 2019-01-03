package com.perfectmatch.persistence.model;

import static org.assertj.core.api.BDDAssertions.then;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArtistTest {

	@Test
	public void testEqualsAndHashCode() {
		Artist artist = Artist.builder()
					.id("124").name("Name")
					.build();
		Artist sameArtist = Artist.builder()
				.id("124").name("Name")
				.build();
		
		then(artist)
      	.as("Is the same object")
      	.isEqualTo(sameArtist);
		
		then(sameArtist.hashCode())
      	.as("Has the same hashcode")
      	.isEqualTo(sameArtist.hashCode());
		
	}

	@Test
	public void testEqualsAndHashCodeWithWebSites() {
		List<String> websites = new ArrayList<String>(1);
		websites.add("NameWebsite");
		Artist artist = Artist.builder()
					.id("124").name("Name")
					.websites(websites)
					.build();
		
		Artist sameArtist = Artist.builder()
				.id("124").name("Name")
				.build();
		
		then(artist)
      	.as("Is the same object")
      	.isEqualTo(sameArtist);
		
		then(sameArtist.hashCode())
      	.as("Has the same hashcode")
      	.isEqualTo(sameArtist.hashCode());
		
	}
	
}
