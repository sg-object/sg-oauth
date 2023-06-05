package com.sg.oauth.client.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ClientInfo {

  private String clientId;

  private String clientSecret;
}
