package com.sg.oauth.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sg.oauth.user.model.User;

@RequestMapping("user")
@RestController
public class UserController {

  @GetMapping
  public User getUser() {
    return User.builder().name("sg.object").age(32).build();
  }
}
