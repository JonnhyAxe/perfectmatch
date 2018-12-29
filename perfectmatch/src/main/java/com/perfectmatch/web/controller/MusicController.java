package com.perfectmatch.web.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.exception.MusicNotFoundException;
import com.perfectmatch.web.services.MusicService;
import io.swagger.annotations.ApiOperation;

/*
 * Controller of the Music Entity
 */

@RestController
@RequestMapping("/music")
public class MusicController {

  @Autowired private MusicService musicService;

  @GetMapping
  @Secured({"ROLE_USER_READ"})
  @ApiOperation(value = "Find all musics - without pagination"
    /** notes = "Also returns a link to retrieve all students with rel - all-students" **/)
  //https://github.com/in28minutes/spring-boot-examples/blob/master/spring-boot-2-rest-service-with-swagger/src/main/java/com/in28minutes/springboot/rest/example/student/StudentResource.java
  public List<Music> getAllMusics() {
    return musicService.findAll();
  }

  @GetMapping(path = "/{name}")
  @ApiOperation(value = "Find Music by name"
    /** notes = "Also returns a link to retrieve all students with rel - all-students" **/)
  public Music getMusicByName(@PathVariable("name") @Valid final String musicName) {
    return Optional.ofNullable(musicService.findByName(musicName)).orElseThrow(() -> new MusicNotFoundException("Music not found for the given name : " + musicName)); 
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Music createMusic(@RequestBody @Valid final Music resource) {
    return musicService.save(resource);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Music updateMusic(@RequestBody final Music resource) {
    return musicService.updateMusic(resource);
  }
}
