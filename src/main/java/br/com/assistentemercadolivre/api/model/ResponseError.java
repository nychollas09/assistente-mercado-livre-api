package br.com.assistentemercadolivre.api.model;

public class ResponseError {

	private int status;
	private String message;

	public ResponseError(String message, int status) {
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
