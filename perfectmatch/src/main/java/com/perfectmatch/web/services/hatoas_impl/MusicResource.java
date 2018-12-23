package com.perfectmatch.web.services.hatoas_impl;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.perfectmatch.persistence.model.Music;
import com.perfectmatch.web.controller.MusicController;

/**
 * Adds HATEOS support to Music Entity
 *
 */
public class MusicResource extends ResourceSupport {

  private Music music;

  public MusicResource(Music music) {
    this.music = music;
    this.add(linkTo(MusicController.class).withRel("music"));
    this.add(
        linkTo(methodOn(MusicController.class, music).getMusicByName(music.getName()))
            .withSelfRel());
  }

  /**
   * @return the music
   */
  public Music getMusic() {

    return music;
  }
}
