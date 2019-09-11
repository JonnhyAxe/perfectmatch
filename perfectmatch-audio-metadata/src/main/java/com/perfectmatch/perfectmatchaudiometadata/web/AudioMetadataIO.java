package com.perfectmatch.perfectmatchaudiometadata.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mpatric.mp3agic.app.LocalMp3Catalog;

@RestController
@RequestMapping("/audio-metadata")
public class AudioMetadataIO {
	
	private static final String VALID_MP3_FILENAME_WITH_CUSTOM_TAG2 = "src/main/resources/Senzala - Sunset (Mashup Mix) www.my-free-mp3.net _pn_live_key.mp3";

	@GetMapping(path = "/{url}")
	public String getAudioMetadata(@PathVariable("url") String url) {
		LocalMp3Catalog mp3Catalog = new LocalMp3Catalog(VALID_MP3_FILENAME_WITH_CUSTOM_TAG2);

		return mp3Catalog.getLastOut();
	}

}
