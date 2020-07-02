package br.com.assistentemercadolivre.api.service.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.assistentemercadolivre.api.service.AuthenticationService;
import br.com.assistentemercadolivre.api.service.request.RequestComponent;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private RestTemplate restTemplate;
	private String baseUrl;
	private RequestComponent requestComponent;

	public AuthenticationServiceImpl(RestTemplate restTemplate, @Value("${api.mercadolivre.auth}") String baseUrl,
			RequestComponent requestComponent) {
		this.restTemplate = restTemplate;
		this.baseUrl = baseUrl;
		this.requestComponent = requestComponent;
	}

	@Override
	public Object authentication(String clientId, String clientSecret, String code, String grantType,
			String redirectUri) {
		URI uri = createUri(clientId, clientSecret, code, grantType, redirectUri);
		HttpEntity<Object> request = new HttpEntity<>(createHttpHeaders());
		return this.requestComponent.send(this.restTemplate, uri, request);
	}

	private HttpHeaders createHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	private URI createUri(String clientId, String clientSecret, String code, String grantType, String redirectUri) {
		Map<String, String> mapParams = new HashMap<String, String>();
		mapParams.put("client_id", clientId);
		mapParams.put("client_secret", clientSecret);
		mapParams.put("code", code);
		mapParams.put("grant_type", grantType);
		mapParams.put("redirect_uri", redirectUri);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(this.baseUrl).queryParam("client_id", clientId)
				.queryParam("client_secret", clientSecret).queryParam("code", code).queryParam("grant_type", grantType)
				.queryParam("redirect_uri", redirectUri);

		return builder.buildAndExpand(mapParams).toUri();
	}

}
