package com.perfectmatch.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <class description>
 *
 */

@Configuration
@ComponentScan({ "com.perfectmatch.controller" })
@EnableWebMvc
public class PerfectMatchWebConfig {

}
