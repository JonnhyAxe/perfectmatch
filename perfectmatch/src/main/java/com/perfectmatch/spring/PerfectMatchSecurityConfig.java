package com.perfectmatch.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class PerfectMatchSecurityConfig extends WebSecurityConfigurerAdapter {


  @Value("${spring.security.user.name}")
  private String username;

  @Value("${spring.security.user.password}")
  private String password;

  // @Autowired
  // private UserDetailsService userDetailsService;

  @Autowired
  public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception {
    final PasswordEncoder sha256 = new StandardPasswordEncoder();

    // auth.userDetailsService(userDetailsService);
    auth.inMemoryAuthentication().passwordEncoder(sha256).withUser(username)
        .password(sha256.encode(password)).roles("USER");

  }

  @Override
  protected void configure(final HttpSecurity httpSecurity) throws Exception {
    // super.configure(httpSecurity);
    //
//    // @formatter:off
//    httpSecurity
//        .authorizeRequests()
//        .anyRequest()
//        .permitAll();
//    // @formatter:on
    //
    // httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
    // .antMatchers("/console/**").permitAll();
    //
    //
    // httpSecurity.anonymous().and().authorizeRequests().antMatchers("/").permitAll();
    //
    // httpSecurity.csrf().disable();
    // httpSecurity.headers().frameOptions().disable();

    httpSecurity.httpBasic();
  }

}
