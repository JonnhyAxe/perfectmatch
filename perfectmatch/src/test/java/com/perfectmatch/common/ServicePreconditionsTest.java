package com.perfectmatch.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.Test;

import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyEntityNotFoundException;

public class ServicePreconditionsTest {

  @Test
  public void testCheckEntityObjectExists() {
	  //Given
	  Music music = new Music();
	  
	  //When
	  Music musicExpected = ServicePreconditions.checkEntityExists(music);
	  
	  //Then
	  assertThat(musicExpected).isNotNull().isEqualTo(music);
  }
  
  @Test(expected = MyEntityNotFoundException.class)
  public void testCheckEntityObjectNotExists() {
	  //Given
	  Music music = null;
	  
	  //When
	  ServicePreconditions.checkEntityExists(music);
	  
	  //Then - MyEntityNotFoundException
  }
  
  
  @Test
  public void testCheckEntityExists() {
	  //Given
	  Music music = new Music();
	  
	  //When
	  ServicePreconditions.checkEntityExists(Objects.nonNull(music));
	  
	  //Then
	  assertThat(music).isNotNull();
  }
  
  
  @Test(expected = MyEntityNotFoundException.class)
  public void testCheckEntityNotExists() {
	  //Given
	  Music music = null;
	  
	  //When
	  ServicePreconditions.checkEntityExists(Objects.nonNull(music));
	  
	  //Then - MyEntityNotFoundException
  }
  
  @Test
  public void testCheckEntityArgumentExists() {
	  //Given
	  Music music = new Music();
	  
	  //When
	  ServicePreconditions.checkOKArgument(Objects.nonNull(music));
	  
	  //Then
	  assertThat(music).isNotNull();
  }
  
  
  @Test(expected = MyBadRequestException.class)
  public void checkEntityArgumentNotExists() {
	  //Given
	  Music music = null;
	  
	  //When
	  ServicePreconditions.checkOKArgument(Objects.nonNull(music));
	  
	  //Then - MyEntityNotFoundException
  }
}
