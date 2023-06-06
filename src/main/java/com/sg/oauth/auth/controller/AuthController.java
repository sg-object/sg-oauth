package com.sg.oauth.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sg.oauth.auth.param.AuthParam;
import com.sg.oauth.auth.param.TokenParam;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("oauth")
@RequiredArgsConstructor
@RestController
public class AuthController {

	@GetMapping("authorize")
	public void authorize(@Valid final AuthParam param) {
	}

	@PostMapping("token")
	public void getToken(@RequestBody final TokenParam param) {
	}
}
