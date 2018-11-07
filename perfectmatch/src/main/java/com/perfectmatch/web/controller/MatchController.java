
package com.perfectmatch.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
    private SampleMatchRepository matchJpaRepository;

    @GetMapping
	@ApiOperation(value = "Find all Matchs - without pagination")
    public List<Match> findAllMatchs() throws IOException {
        return matchJpaRepository.findAll();
    }
    
    
    @GetMapping(path = "/{music}/{music2}")
	@ApiOperation(value = "Find Match by music pair - without pagination")
    public Match findMatchByMusicPair(@PathVariable("music") String music, 
    		@PathVariable("music2")String music2) throws IOException {
    	Match match1  = matchJpaRepository.findMatchByMusics(music, music2);
    	Match match2 =  matchJpaRepository.findMatchByMusics(music2, music);
    	
    	return match1 != null ? match1 : match2;
    }

}
