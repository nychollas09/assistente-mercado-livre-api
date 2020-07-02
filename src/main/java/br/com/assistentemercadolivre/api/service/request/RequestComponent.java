package br.com.assistentemercadolivre.api.service.request;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RequestComponent {

	public Object send(RestTemplate restTemplate, URI uri, HttpEntity<Object> entity) {
		return restTemplate.exchange(uri, HttpMethod.POST, entity, Object.class).getBody();
	}

}
