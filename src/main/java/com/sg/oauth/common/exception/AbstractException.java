package com.sg.oauth.common.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final String message;

	public String getMessage() {
		return this.message;
	}
}
