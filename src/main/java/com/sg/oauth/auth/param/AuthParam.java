package com.sg.oauth.auth.param;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthParam {

	private ResponseType responseType;

	@NotBlank
	private String clientId;

	@NotBlank
	private String state;

	@NotBlank
	private String redirectUri;
}
