package com.excel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
@Configuration

@EnableWebFluxSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//		http.authorizeExchange()
//				.pathMatchers("/actuator/**")
//				.permitAll()
//			.and()
//				.authorizeExchange()
//				.anyExchange()
//				.authenticated()
//			.and()
//				.oauth2Login(); // to redirect to oauth2 login page.
//			
//
//		return http.build();
//	}
//	
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/actuator/**")
//		.permitAll()
//		.anyRequest()
//		.authenticated()
//	.and()
//		.oauth2Login();
//	}
	
	 @Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated()).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	   }

	

}
