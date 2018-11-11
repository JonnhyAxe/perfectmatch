package com.perfectmatch.web.controller;

import java.io.IOException;
import java.util.List;

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

import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;
import com.perfectmatch.web.services.impl.SampleServiceBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleRepository sampleJpaRepository;
   
    @Autowired
    private SampleServiceBean sampleServiceBean;

    @GetMapping
	@ApiOperation(value = "Find all Samples - without pagination")
    public List<Sample> findAllSamples() throws IOException {

        return sampleServiceBean.findAll();
    }
    
    @GetMapping(path = "/{name}")
	@ApiOperation(value = "Find Match by name")
    public Sample getSampleByName(@PathVariable("name")  @Valid final String sampleName) {
        return sampleServiceBean.findByName(sampleName);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sample createSample(@RequestBody @Valid final Sample resource) {
        return sampleServiceBean.save(resource);
    }
    
    // getAllBYNameOrderedByTimeStamp
    
    //Post name and timestamp

}
