package com.lpu.demo_security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
		http.authorizeHttpRequests((req) ->
			req.requestMatchers("/reg").permitAll().anyRequest().authenticated());
			//req.anyRequest().authenticated());
			//req.anyRequest().permitAll();
			//req.anyRequest().denyAll();
		
		http.formLogin(Customizer.withDefaults());
		//http.httpBasic(Customizer.withDefaults());
	
		return http.build();
	}
	
	@Bean
	public UserDetailsService detailsService() {
		UserDetails user1 = User.withUsername("poori").password("{noop}123").roles("read").build();
		UserDetails user2 = User.withUsername("admin").password("{noop}876").roles("admin").build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}
}
