package com.rentalcar.webapp.config;

import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
 
@Configuration
@EnableTransactionManagement //abilita la gestione delle transazioni
@ComponentScan({"com.rentalcar.webapp.config"}) //selezionare il package dove saranno residenti le classi di configurazioni
@PropertySource("classpath:application.properties") //serve alla calsseJdbcConf per accedere ad un file di configurazione Application.properties
public class HibernateConfig 
{
	@Autowired
	private Environment env; //per accedere alle specifiche di configurazione 
	
	@Autowired
	private DataSource dataSource; //specificata nella JdbcConfig
	
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		
		factory.setJpaVendorAdapter(this.jpaVendorAdapter());
		factory.setDataSource(this.dataSource);
		factory.setPackagesToScan("com.rentalcar.webapp.entities");
		factory.setJpaProperties(this.hibernateProperties());
		factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
		factory.setValidationMode(ValidationMode.NONE);
		
		return factory;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter()
	{
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		
		hibernateJpaVendorAdapter.setShowSql(true);
		hibernateJpaVendorAdapter.setGenerateDdl(false);
		hibernateJpaVendorAdapter.setDatabasePlatform(env.getRequiredProperty("hibernate.dialect"));

		return hibernateJpaVendorAdapter;
	}
	
	private Properties hibernateProperties()
	{
		Properties jpaProperties = new Properties();
		
		jpaProperties.put("javax.persistence.schema-generation.database.action", "none");
		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		return jpaProperties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager()
	{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		
		return transactionManager;
	}
	
}
