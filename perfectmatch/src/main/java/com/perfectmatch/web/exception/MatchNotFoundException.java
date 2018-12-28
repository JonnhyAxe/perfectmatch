package com.perfectmatch.web.exception;

public class MatchNotFoundException  extends RuntimeException {
	

  /**
   * 
   */
  private static final long serialVersionUID = -4209583203699174506L;

  	  public MatchNotFoundException() {
	    super();
	  }

	  public MatchNotFoundException(final String message, final Throwable cause) {
	    super(message, cause);
	  }

	  public MatchNotFoundException(final String message) {
	    super(message);
	  }

	  public MatchNotFoundException(final Throwable cause) {
	    super(cause);
	  }
}
