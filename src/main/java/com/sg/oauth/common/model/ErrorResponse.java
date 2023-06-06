package com.sg.oauth.common.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ErrorResponse {

	private String message;
}
