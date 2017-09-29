package com.perfectmatch.perfectmatch;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PerfectmatchApplication {

	public static void main(String[] args) {

        // SpringApplication.run(PerfectmatchApplication.class, args);
        new SpringApplicationBuilder() //
                .sources(PerfectmatchApplication.class)//
                .run(args);
	}
}
