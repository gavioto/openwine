package com.grafenonet.openwine.core.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:jdbc.properties" })
public class PersistenceJpaConfig {
	
	@Autowired
	private Environment env;	
	
	private static final String[] PACKAGES_TO_SCAN = new String[] {
		"com.grafenonet.openwine.maestros.domain",
		"com.grafenonet.openwine.cuaderno.domain",
		"com.grafenonet.openwine.cuaderno.enums"
	};
	
	public PersistenceJpaConfig() {
		super();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager () {	
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();		
		factoryBean.setDataSource(restDataSource());
		factoryBean.setPersistenceUnitName("jdbc/myDS");
		factoryBean.setPackagesToScan(PACKAGES_TO_SCAN);		
		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter() {
			{
				setDatabasePlatform(env.getProperty("jpa.dialect"));
			}
		};
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter);		
		factoryBean.setJpaProperties(jpaProperties());
		
		return factoryBean;
	}
	
	@Bean 
	public DataSource restDataSource() {	
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));		
		
		return dataSource;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		
		transactionManager.setEntityManagerFactory(this.entityManager().getObject());
		
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
//	@Bean
//	PersistenceAnnotationBeanPostProcessor persistenceAnnotationBeanPostProcessor() {
//		return new PersistenceAnnotationBeanPostProcessor();
//	}	
	
	@SuppressWarnings("serial")
	Properties jpaProperties() {
		return new Properties() {
			{
				setProperty("hibernate.show_sql", env.getProperty("jpa.show_sql"));
				setProperty("hibernate.hbm2ddl.auto", env.getProperty("jpa.hbm2ddl.auto"));
				setProperty("hibernate.dialect", env.getProperty("jpa.dialect"));
				setProperty("hibernate.connection.charset", env.getProperty("jpa.connection.charset"));
				setProperty("hibernate.connection.characterEncoding", env.getProperty("jpa.connection.characterencoding"));
			}
		};
	}	

}
