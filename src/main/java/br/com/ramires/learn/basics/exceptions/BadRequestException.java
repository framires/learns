package br.com.ramires.learn.basics.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class BadRequestException extends HttpClientErrorException {

	private static final long serialVersionUID = -2975539476872469312L;

	public BadRequestException(String entity, String field, String key, String description) {
		super((entity + "." + field + key).toLowerCase(), HttpStatus.BAD_REQUEST, entity + " " + field + description,
				null, null, null);
	}

	public BadRequestException(String fieldKey, String description) {
		super(fieldKey, HttpStatus.BAD_REQUEST, description, null, null, null);
	}
}