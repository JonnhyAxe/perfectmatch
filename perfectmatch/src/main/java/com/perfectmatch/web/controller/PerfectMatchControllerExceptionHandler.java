package com.perfectmatch.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.perfectmatch.web.RestResponseEntityExceptionHandlerData;
import com.perfectmatch.web.exception.ApiError;
import com.perfectmatch.web.exception.PerfectMatchNotFoundException;

/**
 * Maps exceptions to HTTP codes
 */
@RestControllerAdvice
public class PerfectMatchControllerExceptionHandler {
	
  @ExceptionHandler(PerfectMatchNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ApiError handleArtistNotFoundException(PerfectMatchNotFoundException ex) {
	return RestResponseEntityExceptionHandlerData.message(HttpStatus.NOT_FOUND, ex);
  }
}
