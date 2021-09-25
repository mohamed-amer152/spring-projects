package com.amer.spring.practice.Employee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource ;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(securityDataSource);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/employee/**").hasRole("EMPLOYEE")
		.antMatchers("/employee/showaddform").hasRole("MANAGER")
		.antMatchers("/employee/save").hasRole("MANAGER")
		.antMatchers("/employee/showupdateform").hasRole("MANAGER")
		.antMatchers("/employee/delete").hasRole("ADMIN")
		.antMatchers("/resources/**").permitAll()
		.and()
			.formLogin()
			.loginPage("/showlogin")
			.loginProcessingUrl("/auth")
			.permitAll()
		.and()
			.logout()
			.permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/view/access-denied");
		
		;

	}

	
	



}
