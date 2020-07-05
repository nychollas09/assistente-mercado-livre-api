package br.com.assistentemercadolivre.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.assistentemercadolivre.api.service.user.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping("address/{client_id}")
  public ResponseEntity<Object> findAddress(@PathVariable(name = "client_id") String clientId,
      @RequestParam(name = "access_token") String accessToken) {
    return ResponseEntity.ok(service.find(clientId, accessToken));
  }
  
  @GetMapping("me")
 public ResponseEntity<Object> UserMe(@RequestParam(name = "access_token") String accessToken){
    return ResponseEntity.ok(service.me(accessToken));
  }

}
