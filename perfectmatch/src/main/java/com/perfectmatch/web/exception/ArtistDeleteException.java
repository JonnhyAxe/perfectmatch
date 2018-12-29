package com.perfectmatch.web.exception;

public class ArtistDeleteException  extends RuntimeException {
	
	  /**
	 * 
	 */
  private static final long serialVersionUID = 982940084228407227L;

  public ArtistDeleteException() {
    super();
  }
  
  public ArtistDeleteException(final String message) {
    super(message);
  }
}
