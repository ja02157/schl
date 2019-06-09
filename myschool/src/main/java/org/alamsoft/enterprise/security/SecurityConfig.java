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

@EnableWebSecurity(debug = true)
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
    	http.csrf().disable().authorizeRequests().antMatchers("/*").permitAll().and().apply(new JwtConfigurer(jwtTokenProvider));
        //@formatter:off
//        http
//            .httpBasic()
//            .and()
//                .authorizeRequests()
//                .antMatchers("*").permitAll()
//               // .antMatchers(HttpMethod.GET, "/vehicles/**").
//                .antMatchers(HttpMethod.GET, "/list/**").hasRole("admin")
////                .antMatchers(HttpMethod.GET, "/v1/vehicles/**").permitAll()
//                .anyRequest().authenticated()
//            .and()
//            .apply(new JwtConfigurer(jwtTokenProvider));
        //@formatter:on
    }
    
}
