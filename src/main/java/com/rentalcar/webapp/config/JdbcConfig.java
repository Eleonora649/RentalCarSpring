package com.rentalcar.webapp.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement //abilita la gestione delle transazioni
@ComponentScan({"com.rentalcar.webapp.config"}) //selezionare il package dove saranno residenti le classi di configurazioni
@PropertySource(value= {"classpath:application.properties"}) //serve alla calsseJdbcConf per accedere ad un file di configurazione Application.properties
public class JdbcConfig 
{
	@Autowired
	private Environment environment; //utilizzera la classe enviremont per accedere ai valori che verranno inseriti all'interno del file applicatino.prop	

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean 
	public NamedParameterJdbcTemplate getJdbcTemplate(DataSource dataSource)
	{
		return new NamedParameterJdbcTemplate(dataSource);
	}

		//elemento che ci permetterà di leggere i parametri dal nostro file appl.prop
	@Bean(name="dataSource")
	public DataSource dataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	
	  //con hibernate la gestione delle transazioni non viene gestita dal jdbc ma direttamente da hibernate
	  /*@Bean public 
	  DataSourceTransactionManager transactionManager() 
	  {
	  	DataSourceTransactionManager transactionManager = new
	  	DataSourceTransactionManager();
	  	transactionManager.setDataSource(dataSource());
	  	return transactionManager; 
	  } */
}	 
