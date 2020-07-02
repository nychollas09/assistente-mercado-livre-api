package br.com.assistentemercadolivre.api.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.assistentemercadolivre.api.model.ResponseError;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(HttpClientErrorException.class)
	public @ResponseBody ResponseEntity<ResponseError> handleHttpClientErrorException(HttpClientErrorException ex) {
		ResponseError exceptionError = new ResponseError(ex.getMessage(), ex.getStatusCode().value());
		return ResponseEntity.status(ex.getStatusCode()).body(exceptionError);
	}

}
