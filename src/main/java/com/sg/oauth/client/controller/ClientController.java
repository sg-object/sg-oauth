package com.sg.oauth.client.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sg.oauth.client.model.ClientInfo;
import com.sg.oauth.client.param.ClientParam;
import com.sg.oauth.client.service.ClientService;
import lombok.RequiredArgsConstructor;

@RequestMapping("client")
@RequiredArgsConstructor
@RestController
public class ClientController {

  private final ClientService clientService;

  @PostMapping
  public ClientInfo createClientInfo(@RequestBody final ClientParam param) {
    return this.clientService.createClientInfo(param);
  }
}
