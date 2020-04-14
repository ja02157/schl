package org.alamsoft.enterprise.bootstrap;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("org.alamsoft.enterprise")
@EnableJpaRepositories("org.alamsoft.enterprise.repositories")
@EnableSwagger2


@PropertySource("classpath:myschool.properties")
public class MySchoolApplication extends WebMvcConfigurerAdapter {
  //extends WebMvcConfigurationSupport   {
//	@Bean
//	  public RequestMappingHandlerAdapter requestMappingHandlerAdapter()  {
//		  RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
//	    
//	    return handlerAdapter;
//	  }
	
	@Bean
	//@ConfigurationProperties(prefix="app.datasource")
	public DataSource dataSource()  {
	    JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
	    return dataSourceLookup.getDataSource("java:comp/env/jdbc/MyDB");
	}
	
	@Bean
	  public EntityManagerFactory entityManagerFactory()  {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(false);
	    vendorAdapter.setShowSql(true);
	    vendorAdapter.setDatabase(Database.HSQL);
	    
	    Properties prop = new Properties();
	    prop.setProperty("hibernate.show_sql", "true");

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaProperties(prop);
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("org.alamsoft.enterprise");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }
	
	@Bean
	  public PlatformTransactionManager transactionManager() {
		
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }
	
	@Bean
    public Docket api() {
        // @formatter:off
        //Register the controllers to swagger
        //Also it is configuring the Swagger Docket
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                //.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(PathSelectors.any())
                // .paths(PathSelectors.ant("/swagger2-demo"))
                .build();
        // @formatter:on
    }
	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) 
	    {
	        //enabling swagger-ui part for visual documentation
	        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
	        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	    }
//	
//	@Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .components(new Components())
//                .info(new Info().title("Contact Application API").description(
//                        "This is a sample Spring Boot RESTful service using springdoc-openapi and OpenAPI 3."));
//    }
}
