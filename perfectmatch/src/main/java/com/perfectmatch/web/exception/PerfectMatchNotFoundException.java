package com.perfectmatch.web.exception;

public class PerfectMatchNotFoundException  extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = -8979124204067905836L;

  public PerfectMatchNotFoundException() {
    super();
  }

  public PerfectMatchNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public PerfectMatchNotFoundException(final String message) {
    super(message);
  }

  public PerfectMatchNotFoundException(final Throwable cause) {
    super(cause);
  }
}
