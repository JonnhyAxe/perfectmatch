package com.perfectmatch.persistence.model;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;

public class MusicTest {

	@Test
	public void testEqualsAndHashCode() {
		Music music = Music.builder()
					.id("124").name("Name")
					.build();
		Music sameMusic = Music.builder()
				.id("124").name("Name")
				.build();
		
		then(music)
      	.as("Is the same object")
      	.isEqualTo(sameMusic);
		
		then(music.hashCode())
      	.as("Has the same hashcode")
      	.isEqualTo(sameMusic.hashCode());
		
	}

	@Test
	public void testEqualsAndHashCodeWithDifferentMetadata() {
		
		Music music = Music.builder()
				.id("124").name("Name")
				.recordLabel("musicRecordLabel")
				.key("musicKey")
				.energy("9")
				.tempo("122")
				.build();
		Music sameMusic = Music.builder()
				.id("124").name("Name")
				.recordLabel("sameMusicRecordLabel")
				.key("sameMusicKey")
				.energy("10")
				.tempo("124")
				.build();
		
		then(music)
	  	.as("Has the same equal and hashcode")
	  	.isEqualTo(sameMusic);
	
		then(music.hashCode())
      	.as("Has the same hashcode")
      	.isEqualTo(sameMusic.hashCode());
	}

}
