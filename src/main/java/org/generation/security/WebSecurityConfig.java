package org.generation.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;


@Configuration
@CrossOrigin(origins="*")
@SuppressWarnings("deprecation")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter  {

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.httpBasic()
			.and()
			.authorizeRequests()
				//.antMatchers(HttpMethod.POST, "/api/clientes/**").permitAll()				
				.anyRequest().permitAll()//.authenticated() 
				.and()
				//.addFilterBefore(new LoginFilter("/login", authenticationManager()),
				//		UsernamePasswordAuthenticationFilter.class)
				//.addFilterBefore(new JwtFilter(),UsernamePasswordAuthenticationFilter.class)
				.csrf().disable();
				
			
								
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("eli") //username
			.password("{noop}patrona") //password
			.roles("ADMIN")
			.and()
			.withUser("puercoespin")
			.password("{noop}mamado")
			.roles("USER")
			.and()
			.withUser("elizabeth@gmail.com")
			.password("{noop}12345678")
			.roles("student")
			.and()
			.withUser("jessi@gmail.com")
			.password("{noop}1234567")
			.roles("student")
			.and()
			.withUser("kevin@gmail.com")
			.password("{noop}123456")
			.roles("student")
			.and()
			.withUser("rodrigo@gmail.com")
			.password("{noop}12345678")
			.roles("USER4");
		
	}
	
}
