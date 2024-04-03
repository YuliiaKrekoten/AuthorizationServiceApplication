package ru.netology.authorizationservice.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.Authorities;
import ru.netology.authorizationservice.Authorization.AuthorizationService;
import ru.netology.authorizationservice.Credentials.InvalidCredentials;
import ru.netology.errorUser.UnauthorizedUser;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public ResponseEntity<String> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        try {
            List<Authorities> authorities = service.getAuthorities(user, password);
            return ResponseEntity.ok(authorities.toString());
        } catch (InvalidCredentials e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (UnauthorizedUser e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
