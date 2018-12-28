package com.perfectmatch.web.exception;

public class ArtistNotFoundException  extends RuntimeException {
	
	  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public ArtistNotFoundException() {
	    super();
	  }

	  public ArtistNotFoundException(final String message, final Throwable cause) {
	    super(message, cause);
	  }

	  public ArtistNotFoundException(final String message) {
	    super(message);
	  }

	  public ArtistNotFoundException(final Throwable cause) {
	    super(cause);
	  }
}
