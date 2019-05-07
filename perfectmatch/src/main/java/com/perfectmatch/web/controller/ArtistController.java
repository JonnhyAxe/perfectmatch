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
import com.perfectmatch.web.exception.ArtistNotFoundException;
import com.perfectmatch.web.services.ArtistService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artist")
public class ArtistController {

  @Autowired
  private ArtistService artistService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Artist> createArtist(@RequestBody @Valid final Artist artist) {
    return artistService.createArtist(artist);
  }

  @GetMapping(path = "/id/{id}")
  public Mono<Artist> getArtistById(@PathVariable("id") String id) {

    // return registry.getInstance(InstanceId.of(id))
    // .filter(Instance::isRegistered)
    // .map(ResponseEntity::ok)
    // .defaultIfEmpty(ResponseEntity.notFound().build());

    return artistService.getArtistById(id).switchIfEmpty(Mono.defer(() -> Mono
        .error(() -> new ArtistNotFoundException("Artist not found for the given id : " + id))));

  }

  @GetMapping(path = "/{name}")
  public Mono<Artist> getArtistByName(@PathVariable("name") String name) {
    final String encodedName = UriUtils.decode(name, StandardCharsets.UTF_8.name());

    return artistService.getArtistByName(encodedName)
        .switchIfEmpty(Mono.defer(() -> Mono.error(() -> new ArtistNotFoundException(
            "Artist not found for the given name : " + encodedName))));

  }

  @DeleteMapping(path = "/{name}")
  public Mono<Artist> deleteArtistByName(@PathVariable("name") String name) {
    final String encodedName = UriUtils.decode(name, StandardCharsets.UTF_8.name());

    return artistService.deleteArtistByName(name)
        .switchIfEmpty(Mono.defer(() -> Mono.error(() -> new ArtistNotFoundException(
            "Artist not found for the given name : " + encodedName))));
  }

  public void setArtistService(ArtistService artistService) {
    this.artistService = artistService;
  }
}
