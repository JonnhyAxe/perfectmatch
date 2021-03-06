package com.perfectmatch.web;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyEntityNotFoundException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private Logger log = LoggerFactory.getLogger(getClass());

  public RestResponseEntityExceptionHandler() {
    super();
  }

  // API

  // 400

  @Override // In the case of the Entity field is incorrect
  protected final ResponseEntity<Object> handleHttpMessageNotReadable(
      final HttpMessageNotReadableException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {
	  log.error(RestResponseEntityExceptionHandlerData.getStringCauseMessage(ex));
    return handleExceptionInternal(
        ex, RestResponseEntityExceptionHandlerData.message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
  }

  @Override // In the case of an Identity field without value -  required @Validation
  protected final ResponseEntity<Object> handleMethodArgumentNotValid(
      final MethodArgumentNotValidException ex,
      final HttpHeaders headers,
      final HttpStatus status,
      final WebRequest request) {
	  log.error(RestResponseEntityExceptionHandlerData.getStringCauseMessage(ex));
    return handleExceptionInternal(
        ex, RestResponseEntityExceptionHandlerData.message(HttpStatus.BAD_REQUEST, ex), headers, HttpStatus.BAD_REQUEST, request);
  }

  @ExceptionHandler(
    value = {
      DataIntegrityViolationException.class,
      MyBadRequestException.class,
      ConstraintViolationException.class,
      MyEntityNotFoundException.class
    }
  )
  protected final ResponseEntity<Object> handleBadRequest(
      final RuntimeException ex, final WebRequest request) {
	  log.error(RestResponseEntityExceptionHandlerData.getStringCauseMessage(ex));
    return handleExceptionInternal(
        ex,
        RestResponseEntityExceptionHandlerData.message(HttpStatus.BAD_REQUEST, ex),
        new HttpHeaders(),
        HttpStatus.BAD_REQUEST,
        request);
  }

}
