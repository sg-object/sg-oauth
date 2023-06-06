package com.sg.oauth.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.oauth.web.filter.SkipPathRequestMatcher;
import com.sg.oauth.web.filter.TokenAuthenticationFilter;
import com.sg.oauth.web.handler.ForbiddenFailureHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(final HttpSecurity http, final AuthenticationManager manager) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(req -> req.anyRequest().authenticated());
		http.addFilterBefore(tokenAuthenticationFilter(manager), UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/oauth/**");
	}

	@Bean
	AuthenticationManager authenticationManager(final HttpSecurity http) throws Exception {
		final var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		return builder.build();
	}

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	private TokenAuthenticationFilter tokenAuthenticationFilter(final AuthenticationManager manager) {
		final var filter = new TokenAuthenticationFilter(new SkipPathRequestMatcher(Arrays.asList("/oauth/**")),
				objectMapper());
		filter.setAuthenticationFailureHandler(new ForbiddenFailureHandler());
		filter.setAuthenticationManager(manager);
		return filter;
	}
}
