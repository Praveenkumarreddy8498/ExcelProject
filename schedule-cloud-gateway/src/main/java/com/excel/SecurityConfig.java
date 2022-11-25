package com.excel;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(jsr250Enabled = true)
@Import(KeycloakSpringBootConfigResolver.class)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		
//        http.csrf().disable().authorizeRequests()
//        .antMatchers("/excel/**").hasRole("ADMIN")
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();

		super.configure(http);
		http.authorizeRequests().anyRequest().permitAll();
		http.csrf().disable();

	}

	/**
	 * @param auth
	 * @throws Exception use for set security while maintaining your config class
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
		keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
		auth.authenticationProvider(keycloakAuthenticationProvider);
	}

	/**
	 * Allows pluggable support for HttpSession-related behaviour when an
	 * authentication occurs
	 */
	
	@Override
	protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
		return new NullAuthenticatedSessionStrategy();
	}

	public KeycloakConfigResolver KeycloakConfigResolver() {
		return new KeycloakSpringBootConfigResolver();
	}

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
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/actuator/**")
//		.permitAll()
//		.anyRequest()
//		.authenticated()
//	.and()
//		.oauth2Login();
//	}

//	 @Override
//	   protected void configure(HttpSecurity http) throws Exception {
//	      http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated()).oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
//	   }

}
