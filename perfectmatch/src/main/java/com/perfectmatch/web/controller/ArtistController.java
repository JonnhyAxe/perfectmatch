package com.perfectmatch.web.controller;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

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
import com.perfectmatch.web.exception.ArtistNotFoundException;
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
    return Optional.ofNullable(artistService.getArtistById(id)).orElseThrow(() -> new ArtistNotFoundException("Artist not found for the given id : " + id)); 
  }

  @GetMapping(path = "/{name}")
  public Artist getArtistByName(@PathVariable("name") String name) {
	  final String encodedName = UriUtils.decode(name, StandardCharsets.UTF_8.name());
	  return  Optional.ofNullable(artistService.getArtistByName(encodedName)).orElseThrow(() -> new ArtistNotFoundException("Artist not found for the given name : " + encodedName));
  }

  @DeleteMapping(path = "/{name}")
  public Artist deleteArtistByName(@PathVariable("name") String name) {
    final String encodedName = UriUtils.decode(name, StandardCharsets.UTF_8.name());
    return Optional.ofNullable(artistService.deleteArtistByName(name)).orElseThrow(() -> new ArtistNotFoundException("Artist not found for the given name : " + encodedName));
  }
}
