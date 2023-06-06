package com.sg.oauth.web.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import com.sg.oauth.web.model.TokenAuthentication;

@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

	private final String BEARER_PREFIX = "Bearer ";

	private final String BASIC_PREFIX = "Basic ";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final var token = authentication.getCredentials().toString();
		if (token.startsWith(BEARER_PREFIX)) {
			return null;
		} else if (token.startsWith(BASIC_PREFIX)) {
			return null;
		} else {
			return null;
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return TokenAuthentication.class.isAssignableFrom(authentication);
	}
}
