package com.mcommandes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final String ADMIN = "ADMIN";
	private static final String USER;

	static {
		USER = "USER";
	}


	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception
	{
		auth.inMemoryAuthentication()
	    .withUser("admin").password("123")
	    .roles("ADMIN","PROF");
	auth.inMemoryAuthentication()
	    .withUser("prof").password("123")
	    .roles("PROF");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/admin").hasRole(ADMIN)
//			.antMatchers("/user").hasAnyRole(ADMIN, USER)
//			.antMatchers("/all").permitAll()
//			.and().formLogin();
		
		
	http
        .authorizeRequests()
        .antMatchers(HttpMethod.GET, "/commades/**").hasRole("USER")
        .antMatchers(HttpMethod.POST, "/savecommandes").hasRole("ADMIN")
        .antMatchers(HttpMethod.PUT, "/commandes/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.PATCH, "/commandes/**").hasRole("ADMIN")
        .antMatchers(HttpMethod.DELETE, "/commandes/**").hasRole("ADMIN")
        .antMatchers("/all").permitAll()
        .and()
        .csrf().disable()
        .formLogin().disable();
	}

	

}
