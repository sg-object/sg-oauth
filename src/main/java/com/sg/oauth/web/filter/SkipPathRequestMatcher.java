package com.sg.oauth.web.filter;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import jakarta.servlet.http.HttpServletRequest;

public class SkipPathRequestMatcher implements RequestMatcher {

	private final OrRequestMatcher orRequestMatcher;

	public SkipPathRequestMatcher(final List<String> skipPathList) {
		if (skipPathList.isEmpty()) {
			throw new RuntimeException();
		}
		this.orRequestMatcher = new OrRequestMatcher(
				skipPathList.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList()));
	}

	@Override
	public boolean matches(HttpServletRequest request) {
		return !orRequestMatcher.matches(request);
	}
}
