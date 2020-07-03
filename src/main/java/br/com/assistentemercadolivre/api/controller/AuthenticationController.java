package br.com.assistentemercadolivre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.assistentemercadolivre.api.service.user.AuthenticationService;

@RestController
@RequestMapping("api/")
public class AuthenticationController {

  @Autowired
  private AuthenticationService service;

  @PostMapping("assistente/auth")
  public Object authentication(@RequestParam(value = "client_id") String clientId,
      @RequestParam(value = "client_secret") String clientSecret,
      @RequestParam(value = "code") String code,
      @RequestParam(value = "grant_type") String grantType,
      @RequestParam(value = "redirect_uri") String redirectUri) {
    return ResponseEntity
        .ok(service.authentication(clientId, clientSecret, code, grantType, redirectUri));
  }

}
