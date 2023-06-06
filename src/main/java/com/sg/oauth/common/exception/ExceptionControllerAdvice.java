package com.sg.oauth.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sg.oauth.common.model.ErrorResponse;
import com.sg.oauth.common.model.ValidErrorResponse;
import com.sg.oauth.common.model.ValidErrorResponse.Field;

@RestControllerAdvice
public class ExceptionControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public ValidErrorResponse handleBindException(final BindException e) {
		return ValidErrorResponse.builder().errors(e.getAllErrors().stream().map(o -> {
			final var fieldError = (FieldError) o;
			return Field.builder().name(fieldError.getField()).message(fieldError.getDefaultMessage()).build();
		}).toList()).build();
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenException.class)
	public ErrorResponse handleForbiddenException(final ForbiddenException e) {
		return ErrorResponse.builder().message(e.getMessage()).build();
	}
}
