package com.perfectmatch.web.exception;

public class SampleNotFoundException  extends RuntimeException {
	
  /**
   * 
   */
  private static final long serialVersionUID = 2971226363377815941L;

  public SampleNotFoundException() {
	super();
  }

  public SampleNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public SampleNotFoundException(final String message) {
    super(message);
  }

  public SampleNotFoundException(final Throwable cause) {
    super(cause);
  }
}
