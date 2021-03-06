package com.perfectmatch.web.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping("/sample")
public class SampleController {
	
  @Autowired private SampleServiceBean sampleServiceBean;

  @GetMapping
  @ApiOperation(value = "Find all Samples - without pagination")
  public List<Sample> findAllSamples() {
    return sampleServiceBean.findAll();
  }

  @GetMapping(path = "/{name}")
  @ApiOperation(value = "Find Match by name")
  public Sample getSampleByName(@PathVariable("name") final String sampleName) {
    return Optional.ofNullable(sampleServiceBean.findByName(sampleName)).orElseThrow(() -> new SampleNotFoundException("Sample not found for the given name : " + sampleName)); 
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Sample createSample(@RequestBody @Valid final Sample resource) {
    return sampleServiceBean.save(resource);
  }

}
