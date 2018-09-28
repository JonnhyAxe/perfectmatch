package com.perfectmatch.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleRepository sampleJpaRepository;

    @GetMapping
	@ApiOperation(value = "Find all Samples - without pagination")
    public List<Sample> findAllSamples() throws IOException {

        return sampleJpaRepository.findAll();
    }

}
