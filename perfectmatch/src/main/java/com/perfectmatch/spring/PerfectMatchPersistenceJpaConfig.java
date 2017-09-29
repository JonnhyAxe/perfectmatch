package com.perfectmatch.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({ "com.perfectmatch.persistence" })
@PropertySource({ "classpath:application-${persistenceTarget:h2}.properties" })
@EnableJpaRepositories(basePackages = "com.perfectmatch.persistence.dao")
public class PerfectMatchPersistenceJpaConfig {

}
