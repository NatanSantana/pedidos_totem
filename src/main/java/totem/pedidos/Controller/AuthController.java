package totem.pedidos.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import totem.pedidos.Security.AuthService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @CrossOrigin(origins = {"https://rrafaelferreira.github.io", "http://localhost:5173"})
    @PostMapping("/autenticar")
    public ResponseEntity<?> autenticar(Authentication authentication) {
        String token = authService.authenticate(authentication);
        return ResponseEntity.ok().body(token);
    }




}
