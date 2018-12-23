package com.perfectmatch.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perfectmatch.security.SimpleCorsFilter;

@Configuration
public class PerfectMatchServletConfig {

  public PerfectMatchServletConfig() {
    super();
  }

  // beans

  @Bean
  public SimpleCorsFilter simpleCorsFilter() {
    return new SimpleCorsFilter();
  }
}
