package com.perfectmatch.web.controller;

import java.nio.charset.StandardCharsets;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import com.perfectmatch.persistence.model.Artist;
import com.perfectmatch.web.services.ArtistService;

@RestController
@RequestMapping("/artist")
public class ArtistController {

  @Autowired private ArtistService artistService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Artist createArtist(@RequestBody @Valid final Artist artist) {
    return artistService.createArtist(artist);
  }

  @GetMapping(path = "/id/{id}")
  public Artist getArtistById(@PathVariable("id") String id) {
	  //TODO: change status code to NotFound
    return artistService.getArtistById(id); 
  }

  @GetMapping(path = "/{name}")
  public Artist getArtistByName(@PathVariable("name") String name) {
	  //TODO: Decode specila characters
	  //TODO: change status code to NotFound
	  return artistService.getArtistByName(name);
  }

  @DeleteMapping(path = "/{name}")
  public Artist deleteArtistByName(@PathVariable("name") String name) {
    name = UriUtils.decode(name, StandardCharsets.UTF_8.name());
  //TODO: change status code to NotFound
    return artistService.deleteArtistByName(name);
  }
}
