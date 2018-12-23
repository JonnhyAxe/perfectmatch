package com.perfectmatch.web.exception;

public final class MyEntityNotFoundException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public MyEntityNotFoundException() {
    super();
  }

  public MyEntityNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public MyEntityNotFoundException(final String message) {
    super(message);
  }

  public MyEntityNotFoundException(final Throwable cause) {
    super(cause);
  }
}
