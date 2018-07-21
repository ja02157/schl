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
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("org.alamsoft.enterprise")
@EnableJpaRepositories("org.alamsoft.enterprise.repositories")

@PropertySource("classpath:myschool.properties")
public class MySchoolApplication extends WebMvcConfigurationSupport   {
	@Bean
	  public RequestMappingHandlerAdapter requestMappingHandlerAdapter()  {
		  RequestMappingHandlerAdapter handlerAdapter = super.requestMappingHandlerAdapter();
	    
	    return handlerAdapter;
	  }
	
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
}
