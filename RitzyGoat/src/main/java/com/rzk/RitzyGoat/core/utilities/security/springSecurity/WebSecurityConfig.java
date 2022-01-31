package com.rzk.RitzyGoat.core.utilities.security.springSecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rzk.RitzyGoat.core.utilities.security.springSecurity.jwt.AuthEntryPointJwt;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.jwt.AuthTokenFilter;
import com.rzk.RitzyGoat.core.utilities.security.springSecurity.services.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    // securedEnabled = true,
    // jsr250Enabled = true,
    prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
      .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
      
      //authentication
      .authorizeRequests().antMatchers("/api/auth/**").permitAll()
      
      //products
      .antMatchers("/api/products/getAll").permitAll()
      .antMatchers("/api/products/getByProductId**").permitAll()
      
      //filters
      .antMatchers("/api/sizes/getAll").permitAll()
      .antMatchers("/api/materials/getAll").permitAll()
      .antMatchers("/api/genders/getAll").permitAll()
      .antMatchers("/api/designers/getAll").permitAll()
      .antMatchers("/api/colors/getAll").permitAll()
      
      //addresses
      .antMatchers("/api/addresses/getAll").permitAll()
      .antMatchers("/api/cities/getAll").permitAll()
      .antMatchers("/api/counties/getAll").permitAll()
      .antMatchers("/api/neighborhoods/getAll").permitAll()
      .antMatchers("/api/addressTypes/getAll").permitAll()
      
      //product images
      .antMatchers("/api/productImages/getAll").permitAll()
      .antMatchers("/api/productImages/productImageUpload").permitAll()
      .antMatchers("/qr-code").permitAll()

      .antMatchers("/api/productImages/getById**").permitAll()
      
      //categories
      .antMatchers("/api/categories/**/**").permitAll()
      .anyRequest().authenticated();

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
  }
}
