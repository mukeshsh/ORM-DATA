package com.nt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.nt.entity.Project;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean("hkDs")
	 public DataSource createDataSource() {
		 HikariDataSource hkDs=null;
		 hkDs=new HikariDataSource();
		 hkDs.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		 hkDs.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		 hkDs.setUsername("jdbc");
		 hkDs.setPassword("class");
		 hkDs.setMaximumPoolSize(60);
		 hkDs.setMinimumIdle(600);
		 return hkDs;
	 }
	@Bean("sesfact")
   public LocalSessionFactoryBean createLocalSessionFactoryBean() {
	   LocalSessionFactoryBean bean=null;
	   Properties props=null;
	   bean=new LocalSessionFactoryBean();
	   bean.setDataSource(createDataSource());
	   bean.setAnnotatedClasses(Project.class);
	   props=new Properties();
	   props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	   props.setProperty("hibernate.hbm2ddl.auto", "update");
	   props.setProperty("hibernate.show_sql", "true");
	   bean.setHibernateProperties(props);
	   return bean;
   }
	@Bean(name="ht")
	public  HibernateTemplate  createHT() {
		return new HibernateTemplate(createLocalSessionFactoryBean().getObject()); 
	}
}
