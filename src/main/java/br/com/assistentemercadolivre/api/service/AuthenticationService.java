package br.com.assistentemercadolivre.api.service;

public interface AuthenticationService {

	Object authentication(String clientId, String clientSecret, String code, String grantType, String redirectUri);

}
