package com.perfectmatch.persistence.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class SampleTestCase {

  @Test
  public void TestMusicFileLocation() throws MalformedURLException {
    //Given
    String fileName = "Jansons&Senzala-JNZ.mp3";
    String expectedPath =
        "/D:/git/perfectmatch/perfectmatch/target/test-classes/Jansons&Senzala-JNZ.mp3";
    String expectedFile = expectedPath;

    ClassLoader classloader = Thread.currentThread().getContextClassLoader();
    URL fileLocation = classloader.getResource(fileName);

    Sample musicSample = new Sample();
    musicSample.setLocation(fileLocation);

    //Then
    assertThat(fileLocation).isNotNull();
    assertThat(fileLocation.getPath()).isNotBlank().isNotEmpty().isEqualTo(expectedPath);
    assertThat(fileLocation.getFile()).isNotBlank().isNotEmpty().isEqualTo(expectedFile);

    assertThat(musicSample.getLocation()).isNotNull();
    assertThat(musicSample.getLocation().getPath())
        .isNotBlank()
        .isNotEmpty()
        .isEqualTo(fileLocation.getPath());
  }
}
