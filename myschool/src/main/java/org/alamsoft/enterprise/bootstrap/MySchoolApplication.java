package org.alamsoft.enterprise.bootstrap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@EnableWebMvc
@ComponentScan("org.alamsoft")
@PropertySource("classpath:myschool.properties")
public class MySchoolApplication extends WebMvcConfigurationSupport   {
	@Bean
	  public RequestMappingHandlerAdapter requestMappingHandlerAdapter()  {
		  RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
	    
	    return handlerAdapter;
	  }
}
