package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.perfectmatch.persistence.dao.PerfectMatchRepository;
import com.perfectmatch.persistence.model.PerfectMatch;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class PerfectMatchServiceBeanTest {

  @Mock
  PerfectMatchRepository dao;

  @InjectMocks
  PerfectMatchServiceBean perfectMatchService;

  @Test
  public void findPerfectMatchByName() {
    // Given
    String perfectMatchName = "musicNameThis" + "," + "musicNameThat";

    PerfectMatch expectedPerfectMatch = new PerfectMatch();
    expectedPerfectMatch.setName(perfectMatchName);

    Mockito.when(this.dao.findByName(perfectMatchName)).thenReturn(Mono.just(expectedPerfectMatch));

    // When
    PerfectMatch actualPerfectMatch =
        perfectMatchService.findPerfectMatchByName(perfectMatchName).block();

    // Then
    assertThat(actualPerfectMatch).isNotNull().isEqualTo(expectedPerfectMatch);

  }

  @Test(expected = NullPointerException.class)
  public void findPerfectMatchByNullName() {
    // Given
    String perfectMatchName = null;

    // When
    perfectMatchService.findPerfectMatchByName(perfectMatchName);

    // Then

  }



  @Test
  public void savePerfectMatch() {
    // Given
    String perfectMatchName = "musicNameThis" + "," + "musicNameThat";

    PerfectMatch expectedPerfectMatch = new PerfectMatch();
    expectedPerfectMatch.setName(perfectMatchName);

    Mockito.when(this.dao.save(expectedPerfectMatch)).thenReturn(Mono.just(expectedPerfectMatch));

    // When
    PerfectMatch actualPerfectMatch = perfectMatchService.save(expectedPerfectMatch).block();

    // Then
    assertThat(actualPerfectMatch).isNotNull().isEqualTo(expectedPerfectMatch);

  }


  @Test(expected = NullPointerException.class)
  public void saveNullPerfectMatch() {
    // Given
    PerfectMatch expectedPerfectMatch = null;

    // When
    perfectMatchService.save(expectedPerfectMatch);

    // Then
  }
}
