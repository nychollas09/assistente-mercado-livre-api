package br.com.assistentemercadolivre.api.service.user;

public interface UserService {
  Object find(String clientId, String accessToken);

  Object me(String accessToken);
}
