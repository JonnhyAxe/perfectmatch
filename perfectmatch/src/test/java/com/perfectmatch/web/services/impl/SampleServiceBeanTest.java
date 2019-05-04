package com.perfectmatch.web.services.impl;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;
import reactor.core.publisher.Mono;

@RunWith(MockitoJUnitRunner.class)
public class SampleServiceBeanTest {

  @Mock
  SampleRepository sampleRepository;

  @InjectMocks
  SampleServiceBean sampleService;

  @Test
  public void findSampleByName() {
    // Given
    String sampleName = "AwesomeSampletName";
    String sampleId = "AwesomeSampletId";


    Sample expectedSample = new Sample();
    expectedSample.setId(sampleId);
    expectedSample.setName(sampleName);

    Mockito.when(sampleRepository.findByName(sampleName)).thenReturn(Mono.just(expectedSample));


    // When
    Sample actualSample = sampleService.findByName(sampleName).block();

    // Then
    assertThat(actualSample).isNotNull();
    assertThat(actualSample).isEqualTo(expectedSample);
  }

  @Test
  public void saveSample() {
    // Given
    String sampleName = "AwesomeSampletName";
    String sampleId = "AwesomeSampletId";


    Sample expectedSample = new Sample();
    expectedSample.setId(sampleId);
    expectedSample.setName(sampleName);
    expectedSample.setTimestamp(112412);

    Mockito.when(sampleRepository.save(expectedSample)).thenReturn(Mono.just(expectedSample));


    // When
    Sample actualSample = sampleService.save(expectedSample).block();

    // Then
    assertThat(actualSample).isNotNull();
    assertThat(actualSample).isEqualTo(expectedSample);
  }

}
