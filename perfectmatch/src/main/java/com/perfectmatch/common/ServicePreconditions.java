package com.perfectmatch.common;

import java.util.Objects;

import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyEntityNotFoundException;

public final class ServicePreconditions {

  /**
   * Ensures that the entity reference passed as a parameter to the calling
   * method is not null.
   *
   * @param entity
   *            an object reference
   * @return the non-null reference that was validated
   * @throws MyEntityNotFoundException
   *             if {@code entity} is null
   */
  public static <T> T checkEntityExists(final T entity) {

    if (Objects.isNull(entity)) {
      throw new MyEntityNotFoundException();
    }
    return entity;
  }

  public static void checkEntityExists(final boolean entityExists) {

    if (!entityExists) {
      throw new MyEntityNotFoundException();
    }
  }

  public static void checkOKArgument(final boolean okArgument) {

    if (!okArgument) {
      throw new MyBadRequestException();
    }
  }
}
