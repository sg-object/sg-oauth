package com.sg.oauth.client.service;

import org.springframework.stereotype.Service;
import com.sg.oauth.client.model.ClientInfo;
import com.sg.oauth.client.param.ClientParam;

@Service
public class ClientService {

  public ClientInfo createClientInfo(final ClientParam param) {
    return ClientInfo.builder().clientId("testId").clientSecret("testSecret").build();
  }
}
