package com.perfectmatch.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.perfectmatch.web.exception.ArtistNotFoundException;

/**
 * Maps exceptions to HTTP codes
 * @author moises.macero
 */
@RestControllerAdvice
public class ArtistControllerExceptionHandler {
	
  @ExceptionHandler(ArtistNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public void handleNonExistingArtist() {
	  
	  
  }
}
