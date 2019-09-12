package com.perfectmatch.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.perfectmatch.common.services.proxy.AudioMetadataServiceProxy;

@RestController
@RequestMapping("/audio-metadata")
public class AudioMetadataIOController {

  @Autowired
  private AudioMetadataServiceProxy proxy;

  @GetMapping(path = "/{url}")
  public String getAudioMetadata(@PathVariable("url") String url) {
    return proxy.getAudioMetadataIo(url);
  }

}
