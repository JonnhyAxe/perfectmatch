package com.perfectmatch.spring;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.perfectmatch.persistence"})
public class PerfectMatchPersistenceConfig {}
