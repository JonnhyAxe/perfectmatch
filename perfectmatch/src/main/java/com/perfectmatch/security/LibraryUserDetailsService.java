package com.perfectmatch.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.perfectmatch.web.services.UserService;

@Service
public class LibraryUserDetailsService implements UserDetailsService {

  private final UserService userService;

  public LibraryUserDetailsService(UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userService.findOneByEmail(username).map(LibraryUser::new).orElseThrow(
        () -> new UsernameNotFoundException(String.format("No user found for %s", username)));
  }
}
