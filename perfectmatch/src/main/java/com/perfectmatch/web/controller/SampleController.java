package com.perfectmatch.web.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.perfectmatch.persistence.model.Sample;
import com.perfectmatch.web.exception.SampleNotFoundException;
import com.perfectmatch.web.services.impl.SampleServiceBean;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sample")
public class SampleController {

  private static final String SAMPLE_NOT_FOUND_FOR_THE_GIVEN_NAME =
      "Sample not found for the given name : ";
  @Autowired
  private SampleServiceBean sampleServiceBean;

  @GetMapping
  @ApiOperation(value = "Find all Samples - without pagination")
  public Flux<Sample> findAllSamples() {
    return sampleServiceBean.findAll();
  }

  @GetMapping(path = "/{name}")
  @ApiOperation(value = "Find Match by name")
  public Mono<Sample> getSampleByName(@PathVariable("name") final String sampleName) {
    return sampleServiceBean.findByName(sampleName).switchIfEmpty(Mono.defer(() -> Mono.error(
        () -> new SampleNotFoundException(SAMPLE_NOT_FOUND_FOR_THE_GIVEN_NAME + sampleName))));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Sample> createSample(@RequestBody @Valid final Sample resource) {
    return sampleServiceBean.save(resource);
  }

}
