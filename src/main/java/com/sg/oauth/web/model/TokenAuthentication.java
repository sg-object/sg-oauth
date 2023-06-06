package com.sg.oauth.web.model;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class TokenAuthentication extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;

	private Object credentials;

	private Object principal;

	public TokenAuthentication(final Object credentials) {
		super(null);
		this.credentials = credentials;
		setAuthenticated(false);
	}

	public TokenAuthentication(Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
	}

	@Override
	public Object getCredentials() {
		return this.credentials;
	}

	@Override
	public Object getPrincipal() {
		return this.principal;
	}
}
