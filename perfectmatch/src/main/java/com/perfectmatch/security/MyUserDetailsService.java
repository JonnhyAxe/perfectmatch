package com.perfectmatch.security;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Database user authentication service.
 */
// @Component
public final class MyUserDetailsService implements UserDetailsService {

  public MyUserDetailsService() {
    super();
  }

  // API - public

  /**
   * Loads the user from the datastore, by it's user name <br>
   */
  @Override
  public UserDetails loadUserByUsername(final String username) {

    if (!username.equals("JAxe")) {
      throw new UsernameNotFoundException(username + " not found");
    }

    // creating dummy user details, should do JDBC operations
    return new UserDetails() {

      private static final long serialVersionUID = 2059202961588104658L;

      @Override
      public boolean isEnabled() {

        return true;
      }

      @Override
      public boolean isCredentialsNonExpired() {

        return true;
      }

      @Override
      public boolean isAccountNonLocked() {

        return true;
      }

      @Override
      public boolean isAccountNonExpired() {

        return true;
      }

      @Override
      public String getUsername() {

        return username;
      }

      @Override
      public String getPassword() {

        return "jaxe123";
      }

      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> auths = new java.util.ArrayList<>();
        auths.add(new SimpleGrantedAuthority("ROLE_USER_READ"));
        return auths;
      }
    };
  }
}
