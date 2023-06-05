package com.sg.oauth.auth.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthParam {

  private ResponseType responseType;

  private String clientId;

  private String state;

  private String redirectUri;
}
