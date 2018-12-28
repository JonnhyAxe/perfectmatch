
package com.perfectmatch.web.controller;

import java.io.IOException;
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

import com.perfectmatch.persistence.model.PerfectMatch;
import com.perfectmatch.web.exception.PerfectMatchNotFoundException;
import com.perfectmatch.web.services.impl.PerfectMatchServiceBean;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/perfect_match")
public class PerfectMatchController {

  @Autowired private PerfectMatchServiceBean perfectMatchService;

  @GetMapping
  @ApiOperation(value = "Find all Perfect Matchs - without pagination")
  public List<PerfectMatch> findAllPerfectMatchs() throws IOException {
    return perfectMatchService.findAll();
  }

  //by Music and Musics

  @GetMapping(path = "/{name}")
  @ApiOperation(value = "Find Match by name")
  public PerfectMatch getPerfectMatchByName(@PathVariable("name") @NotNull @NotBlank final String matchName) {
    return Optional.ofNullable(perfectMatchService.findPerfectMatchByName(matchName)).orElseThrow(() -> new PerfectMatchNotFoundException("Perfect Match not Found for a given name : " + matchName));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PerfectMatch createPerfectMatch(@RequestBody @Valid final PerfectMatch resource) {
    return perfectMatchService.save(resource);
  }
}
