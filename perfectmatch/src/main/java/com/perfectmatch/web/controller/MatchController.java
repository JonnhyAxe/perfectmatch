
package com.perfectmatch.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.perfectmatch.persistence.dao.SampleMatchRepository;
import com.perfectmatch.persistence.model.Match;
import com.perfectmatch.web.exception.MatchNotFoundException;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/match")
public class MatchController {

  @Autowired private SampleMatchRepository matchJpaRepository;

  @GetMapping
  @ApiOperation(value = "Find all Matchs - without pagination")
  public List<Match> findAllMatchs() {
    return matchJpaRepository.findAll();
  }

  @GetMapping(path = "/{music}/{music2}")
  @ApiOperation(value = "Find Match by music pair - without pagination")
  public Match findMatchByMusicPair(
      @PathVariable("music")  @NotNull @NotBlank String music,
      @PathVariable("music2")  @NotNull @NotBlank String music2) {
   
	Match match1 = matchJpaRepository.findMatchByMusics(music, music2);
    Match match2 = matchJpaRepository.findMatchByMusics(music2, music);

    return Optional.ofNullable(match1 != null ? match1 : match2).orElseThrow(() -> new MatchNotFoundException("Match not found for given music names : " + music + ", " + music2));
  }

  @GetMapping(path = "/{music}")
  @ApiOperation(value = "Find all Matchs by music name - without pagination")
  public List<Match> findAllMatchByMusic(@PathVariable("music") @NotNull @NotBlank String music) {
	  List<Match> matchs = matchJpaRepository.findAllBymusicName(music);
	  return Optional.ofNullable(!matchs.isEmpty() ? matchs : null).orElseThrow(() -> new MatchNotFoundException("Match not found for given music name : " + music));
  }
  
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Match createMatch(@RequestBody @NotNull @Valid final Match resource) {
    return matchJpaRepository.save(resource);
  }
}
