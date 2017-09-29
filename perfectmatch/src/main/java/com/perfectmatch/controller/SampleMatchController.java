
package com.perfectmatch.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;

@RestController
@RequestMapping("/matches")
public class SampleMatchController {

    @Autowired
    private SampleMatchRepository matchJpaRepository;

    @RequestMapping(path = "/repo", method = RequestMethod.GET)
    public Iterable<Match> findByRepo() throws IOException {

        return matchJpaRepository.findAll();
    }

}
