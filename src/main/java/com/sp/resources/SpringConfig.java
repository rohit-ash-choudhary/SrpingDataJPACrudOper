package com.sp.resources;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.sp.repository")
@ComponentScan(basePackages = {"com.sp"})
public class SpringConfig {
	
	@Bean
	public DataSource myDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mydb?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("Rooh@#2001");
		
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory()
	{
		LocalContainerEntityManagerFactoryBean lcEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		
		lcEntityManagerFactoryBean.setDataSource(myDataSource());
		lcEntityManagerFactoryBean.setPackagesToScan("com.sp.entity");
		lcEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		lcEntityManagerFactoryBean.setJpaProperties(Hibernatepropest());
		
		
		return lcEntityManagerFactoryBean;
		
	}
	
	public Properties Hibernatepropest() {
		Properties prop=new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.setProperty("hibernate.show_sql", "true");
		return prop;
		
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
	{
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
		return jpaTransactionManager;
	}
}
