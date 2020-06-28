package org.alamsoft.enterprise.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity(debug = false)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//boolean x = http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/rs/list/**").hasRole("ADMIN");
    	//Object b = http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/list/**").hasRole("USER");
//    	http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/rs/list/**").hasRole("ADMIN").and().apply(new JwtConfigurer(jwtTokenProvider));
    	http.csrf().disable().apply(new JwtConfigurer(jwtTokenProvider));

    	//http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/rs/list/**").hasRole("USER").anyRequest().authenticated();
    	//http.csrf().disable().authorizeRequests().and().apply(new JwtConfigurer(jwtTokenProvider));

    	//@formatter:off
    	
    	
 //       http.csrf().disable()
 //           .httpBasic()
//            .and()
//                .authorizeRequests()
//                .antMatchers("/login")..hasRole("admin")
//               // .antMatchers(HttpMethod.GET, "/vehicles/**").
//                .antMatchers(HttpMethod.GET, "/list").hasRole("admin")
////                .antMatchers(HttpMethod.GET, "/v1/vehicles/**").permitAll()
//                .anyRequest().authenticated()
//            .and()
//            .apply(new JwtConfigurer(jwtTokenProvider));
        //@formatter:on
    }
    
}
