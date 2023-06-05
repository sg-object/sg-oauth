package com.sg.oauth.user.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {

  private String name;

  private int age;
}
