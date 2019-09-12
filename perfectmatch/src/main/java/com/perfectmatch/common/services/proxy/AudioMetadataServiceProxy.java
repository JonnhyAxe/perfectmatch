package com.perfectmatch.common.services.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "perfectmatch-audio-metadata-service")
@RibbonClient(name = "perfectmatch-audio-metadata-service")
public interface AudioMetadataServiceProxy {

  @GetMapping("/audio-metadata/{url}")
  public String getAudioMetadataIo(@PathVariable("url") String url);

}
