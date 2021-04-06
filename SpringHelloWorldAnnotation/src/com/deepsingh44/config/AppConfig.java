package com.deepsingh44.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.deepsingh44.model.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.deepsingh44" })
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {

	//add static resources
	@Override
	   public void addResourceHandlers(ResourceHandlerRegistry registry) {

	      // Register resource handler for CSS and JS
	      registry.addResourceHandler("/images/**").addResourceLocations("/images/");
	   }
	
	/*
	 * @Bean public InternalResourceViewResolver internalResourceViewResolver() {
	 * return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp"); }
	 */

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/rahishdb");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		System.out.println("Deep database " + dataSource);
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		// sessionFactory.setPackagesToScan(new String[] {"com.example.model"});
		sessionFactory.setAnnotatedClasses(User.class);
		sessionFactory.setHibernateProperties(hibernateProperties());
		System.out.println("deep session " + sessionFactory);
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println(properties);
		return properties;
	}

	@Bean
	public HibernateTransactionManager getTransactionManager() {
		System.out.println("transaction " + "hello");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		System.out.println("transaction " + transactionManager);
		return transactionManager;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver cm = new CommonsMultipartResolver();
		cm.setMaxUploadSize(5008528);
		return cm;
	}
}
