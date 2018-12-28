package com.perfectmatch.web.exception;

public class MusicNotFoundException  extends RuntimeException {
	
  /**
   * 
   */
  private static final long serialVersionUID = 2971226363377815941L;

  public MusicNotFoundException() {
	super();
  }

  public MusicNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public MusicNotFoundException(final String message) {
    super(message);
  }

  public MusicNotFoundException(final Throwable cause) {
    super(cause);
  }
}
