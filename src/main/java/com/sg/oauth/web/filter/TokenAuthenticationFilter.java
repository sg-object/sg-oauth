package com.sg.oauth.web.filter;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sg.oauth.common.model.ErrorResponse;
import com.sg.oauth.util.ResponseUtil;
import com.sg.oauth.web.model.TokenAuthentication;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  private final ObjectMapper objectMapper;

  public TokenAuthenticationFilter(final RequestMatcher requestMatcher,
      final ObjectMapper objectMapper) {
    super(requestMatcher);
    this.objectMapper = objectMapper;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    final var token = request.getHeader("Authorization");
    if (token == null) {
      response.setStatus(HttpStatus.UNAUTHORIZED.value());
      ResponseUtil.setJsonResponse(response,
          createErrorJson(ErrorResponse.builder().message("Token is Empty").build()));
      return null;
    }
    return getAuthenticationManager().authenticate(new TokenAuthentication(token));
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request,
      HttpServletResponse response, AuthenticationException failed)
      throws IOException, ServletException {
    response.setStatus(HttpStatus.FORBIDDEN.value());
    ResponseUtil.setJsonResponse(response,
        createErrorJson(ErrorResponse.builder().message("Token Error").build()));
  }

  private String createErrorJson(final ErrorResponse obj) throws JsonProcessingException {
    return this.objectMapper.writeValueAsString(obj);
  }
}
