package com.amer.spring.practice.Employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		UserBuilder user = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(user.username("amer").password("123").roles("EMPLOYEE" , "ADMIN"))
		.withUser(user.username("sheng").password("123").roles("EMPLOYEE" , "MANAGER"))
		.withUser(user.username("any").password("123").roles("EMPLOYEE" ))
		;

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
			.exceptionHandling().accessDeniedPage("/access-denied");
		
		;

	}

	
	



}
