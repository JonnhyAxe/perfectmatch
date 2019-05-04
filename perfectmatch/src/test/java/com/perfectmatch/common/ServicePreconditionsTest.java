package com.perfectmatch.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Objects;
import org.junit.Test;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.exception.MyBadRequestException;
import com.perfectmatch.web.exception.MyEntityNotFoundException;

public class ServicePreconditionsTest {

  @Test
  public void testCheckEntityObjectExists() {
    // Given
    Music music = new Music();

    // When
    Boolean musicExpected = ServicePreconditions.checkEntityExists(music);

    // Then
    assertThat(musicExpected).isNotNull().isEqualTo(music);
  }

  @Test
  public void testCheckEntityObjectNotExists() {
    // Given
    Music music = null;

    // When
    assertThrows(MyEntityNotFoundException.class, () -> {
      ServicePreconditions.checkEntityExists(music);
    });

    // Then - MyEntityNotFoundException
  }


  @Test
  public void testCheckEntityExists() {
    // Given
    Music music = new Music();

    // When
    ServicePreconditions.checkEntityExists(Objects.nonNull(music));

    // Then
    assertThat(music).isNotNull();
  }


  @Test
  public void testCheckEntityNotExists() {
    // Given
    Music music = null;

    // When

    assertThrows(MyEntityNotFoundException.class, () -> {
      ServicePreconditions.checkEntityExists(Objects.nonNull(music));
    });

  }

  @Test
  public void testCheckEntityArgumentExists() {
    // Given
    Music music = new Music();

    // When
    ServicePreconditions.checkOKArgument(Objects.nonNull(music));

    // Then
    assertThat(music).isNotNull();
  }


  @Test
  public void checkEntityArgumentNotExists() {
    // Given
    Music music = null;

    // Then - MyEntityNotFoundException

    assertThrows(MyBadRequestException.class, () -> {
      ServicePreconditions.checkOKArgument(Objects.nonNull(music));
    });
  }
}
