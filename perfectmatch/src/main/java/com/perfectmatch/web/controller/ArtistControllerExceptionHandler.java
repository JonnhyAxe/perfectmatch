package com.perfectmatch.web.controller;

import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.exception.ArtistNotFoundException;

/**
 * Maps exceptions to HTTP codes
 * @author moises.macero
 */
@RestControllerAdvice
public class ArtistControllerExceptionHandler {
	
  @ExceptionHandler(ArtistNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiError handleArtistNotFoundException(ArtistNotFoundException ex) {
	  
	  final String message =
		        ex.getMessage() == null ? ex.getClass().getSimpleName() : ex.getMessage();
      final String devMessage = ExceptionUtils.unwrapInvocationTargetException(ex).getMessage();

	return new ApiError(HttpStatus.BAD_REQUEST.value(), message, devMessage);
  }
}
