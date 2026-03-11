package com.lpu.security1;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) {
//		http.authorizeHttpRequests((req) -> 
//		req.requestMatchers("/hi","/error").permitAll().anyRequest().authenticated());
//		
////			req.anyRequest().authenticated()); // check for login
//		//req.anyRequest().permitAll());
//		//req.anyRequest().denyAll()); //reject all request
//		http.formLogin(Customizer.withDefaults());//for chrome login page
////		http.httpBasic(Customizer.withDefaults());//for postman basic auth
//		return http.build();
//	}
//	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) {
//		http.csrf((c) -> c.disable()); //cross Sight Request Forgery
//		http.sessionManagement((s) -> s.sessionCreationPolicy(SessionCreationPolicy.NEVER));
		//NEVER creates only one session
		//STATELESS - session will not be created
		//by default if_required - creates session when needed
		//ALWAYS - creates session everytime
		http.cors(c->{});//enable CORS  in security
		http.authorizeHttpRequests((req) -> 
				req.requestMatchers("/register", "/public", "/error", "/save").permitAll()
				.requestMatchers("/delete", "/findall").hasRole("ADMIN")
				.requestMatchers("/delete", "/findall").hasAuthority("ADMIN")
				.requestMatchers("/update").hasAnyRole("ADMIN", "USER")
				.requestMatchers("/update").hasAnyAuthority("ADMIN", "USER")
				.anyRequest().authenticated()
				);
		
		
		http.httpBasic(Customizer.withDefaults());
//		http.formLogin(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		
		config.setAllowedOrigins(List.of("http://localhost:3000", "URL"));
		config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
		config.setAllowedHeaders(List.of("*"));
		config.setAllowCredentials(true);
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}

	@Bean
	public PasswordEncoder encoder() { 
		return new BCryptPasswordEncoder();
	}

}
