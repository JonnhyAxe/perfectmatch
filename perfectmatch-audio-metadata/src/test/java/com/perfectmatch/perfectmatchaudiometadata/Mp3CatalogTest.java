package com.perfectmatch.perfectmatchaudiometadata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mpatric.mp3agic.app.Mp3Catalog;

public class Mp3CatalogTest {

	private static final String VALID_MP3_FILENAME_WITH_CUSTOM_TAG2 = "src/test/resources/Senzala - Sunset (Mashup Mix) www.my-free-mp3.net _pn_live_key.mp3";

	@Test
	public void testShouldPrintCatalogLineForValidMp3WithCustomTag() throws Exception {
		Mp3CatalogForTesting mp3Catalog = new Mp3CatalogForTesting(VALID_MP3_FILENAME_WITH_CUSTOM_TAG2);

		assertEquals("\"Senzala - Sunset (Mashup Mix) www.my-free-mp3.net _pn_live_key.mp3\",\"18676185\",\"466\",\"1.0\",\"III\",\"44100\",\"320\",\"CBR\",\"Stereo\",\"1.1\",\"2.3.0\",\"\",\"\",\"\",\"Senzala - Sunset (Mashup Mix) www.my-free-mp3.net _pn_live - 9A - 124,00_pn\",\"\",\"Unknown\",\"Em - Energy 7\",\"\",\"\",\"\",\"\",\"\",\"\",\"Initial key\"", mp3Catalog.lastOut);
	}
	
	class Mp3CatalogForTesting extends Mp3Catalog {
		
		String lastError;
		String lastOut;
		
		public Mp3CatalogForTesting() {
			super();
		}

		public Mp3CatalogForTesting(String filename) {
			super(filename);
//			byte[] customTag = new byte[1];
//			[0] = "".getBytes();

			
		}

		protected void printError(String message) {
			lastError = message;
		}

		protected void printOut(String message) {
			lastOut = message;
		}
		
		
	}
}
