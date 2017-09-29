package com.perfectmatch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.SampleRepository;
import com.perfectmatch.persistence.model.Sample;

@RestController
@RequestMapping("/sample")
public class SampleController {

    @Autowired
    private SampleRepository sampleJpaRepository;

    @RequestMapping(path = "/repo", method = RequestMethod.GET)
    public Iterable<Sample> findByRepo() throws IOException {

        return sampleJpaRepository.findAll();
    }

}
