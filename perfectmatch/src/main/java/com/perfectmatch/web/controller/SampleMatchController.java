
package com.perfectmatch.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/match")
public class SampleMatchController {

    @Autowired
    private SampleMatchRepository matchJpaRepository;

    @GetMapping
	@ApiOperation(value = "Find all Matchs - without pagination")
    public List<Match> findAllMatchs() throws IOException {

        return matchJpaRepository.findAll();
    }

}
