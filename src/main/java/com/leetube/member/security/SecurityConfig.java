package com.leetube.member.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.java.Log;

@Log
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JbUsersService jbUsersService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.info("시큐리티 컨피그");
		
		http.authorizeRequests().antMatchers("/").permitAll();
		http.csrf().disable();
		http.formLogin().loginPage("/login").successHandler(new LoginSuccessHandler());
		http.exceptionHandling().accessDeniedPage("/accessDenied");
		http.logout().logoutUrl("/logout").invalidateHttpSession(true);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		log.info("전체 시큐리티 적용.......");
		auth.userDetailsService(jbUsersService).passwordEncoder(passwordEncoder());
	}
	
}
