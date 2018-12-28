package com.perfectmatch.web;

import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.http.HttpStatus;

import com.perfectmatch.web.exception.ApiError;

public class RestResponseEntityExceptionHandlerData {
	
  public static final ApiError message(final HttpStatus httpStatus, final Exception ex) {

	final String message = getStringCauseMessage(ex);

    final String devMessage = ExceptionUtils.unwrapInvocationTargetException(ex).getMessage();

    return new ApiError(HttpStatus.NOT_FOUND.value(), message, devMessage);
  }
	
  public static  String getStringCauseMessage(final Exception ex){ 
	 return ex.getCause() != null ? ex.getCause().toString() : ex.getMessage();
 }

  
}