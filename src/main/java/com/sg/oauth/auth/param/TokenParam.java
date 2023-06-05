package com.sg.oauth.auth.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenParam {

  private GrantType grantType;

  private String code;

  private String redirectUri;

  private String username;

  private String password;
}
