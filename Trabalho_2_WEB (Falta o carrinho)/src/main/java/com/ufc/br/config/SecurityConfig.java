package com.ufc.br.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ufc.br.security.UserDetailsServiceImplementacao;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsServiceImplementacao userDetailsServiceImple; 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImple).passwordEncoder(new BCryptPasswordEncoder());
		
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**","/js/**","/img/**","/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/pessoa/principal").permitAll()
		.antMatchers("/pessoa/formulario").permitAll()
		.antMatchers("/pessoa/logar").permitAll()
		.antMatchers("/pessoa/salvar").permitAll()
		
		.antMatchers("/pessoa/salvarp").permitAll()
		.antMatchers("/pessoa/salvarpt").permitAll()
		.antMatchers("/pessoa/excluirPrato/{codigo}").permitAll()//hasRole("ADMIN")
		
		
		
		
		.and()
		.formLogin()
		.loginPage("/pessoa/logar").permitAll().defaultSuccessUrl("/pessoa/principal")
		.permitAll()
		

		.and()
		.logout()
		.logoutSuccessUrl("/pessoa/logar?logout")
		.permitAll();

	}
	
}