package com.Initializer;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.Initializer.ModelClasses.Student;

@Configuration
@ComponentScan(basePackages = "com")
@EnableWebMvc
@PropertySource(value = "/WEB-INF/password.properties")
public class AppConfigue {
	@Bean
	public InternalResourceViewResolver resolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public DriverManagerDataSource ds() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/SpringStudent");
		ds.setUsername("root");
		ds.setPassword("4dragozy");
		return ds;
	}
	
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean ();
		sf.setDataSource(ds());
		Properties prop = new Properties();
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		prop.put("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql",true);
		sf.setHibernateProperties(prop);
		sf.setAnnotatedClasses(Student.class);
		return sf;
	}
	
	
}