package org.alamsoft.enterprise.bootstrap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Dynamic;

public class MySchoolInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MySchoolApplication.class);
		// Manage the lifecycle of the root application context
		container.setInitParameter("log4jConfigLocation", "classpath:log4j.xml");
		//container.addListener(new Log4jConfigListener());
		container.addListener(new ContextLoaderListener(rootContext));
		//MDCFilter mdcFilterlocal = new MDCFilter();
		final javax.servlet.FilterRegistration.Dynamic mdcFilter=container.addFilter("mdcFilterlocal", MDCFilter.class);
		
		mdcFilter.addMappingForUrlPatterns(null, true, "/*");
		

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/rs/*");

	}

}
