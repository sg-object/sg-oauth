package com.sg.oauth.common.model;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ValidErrorResponse {

	private List<Field> errors;

	@Builder
	@Getter
	public static class Field {

		private String name;

		private String message;
	}
}
