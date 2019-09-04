package com.perfectmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import com.perfectmatch.spring.PerfectMatchWebConfig;

@SpringBootApplication
@Import({PerfectMatchWebConfig.class})
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@EnableDiscoveryClient
public class PerfectMatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(PerfectMatchApplication.class, args);
  }
}
