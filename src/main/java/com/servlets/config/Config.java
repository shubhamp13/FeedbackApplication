package com.servlets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.servlets.dao.FeedbackDao;
import com.servlets.dao.FeedbackDaoImpl;

@ComponentScan(basePackages = "com.servlets.dao")
@Configuration
public class Config 
{
	@Bean
	public DriverManagerDataSource dataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/form");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate()
	{
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	@Bean
	public FeedbackDao dao()
	{
		FeedbackDaoImpl dao=new FeedbackDaoImpl();
		dao.setJdbcTemplate(jdbcTemplate());
		return dao;
	}
}
