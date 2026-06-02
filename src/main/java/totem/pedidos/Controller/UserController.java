package totem.pedidos.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import totem.pedidos.DTO.UserRequest;
import totem.pedidos.Service.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @CrossOrigin(origins = {"https://rrafaelferreira.github.io/Toten-Restaurante/", "http://localhost:5173"})
    @PostMapping("/sign")
    public ResponseEntity<?> registrar(@RequestBody UserRequest request) {
        userService.registrarUser(request);
        return ResponseEntity.status(201).body("Usuário Criado");
    }

    @CrossOrigin(origins = {"https://rrafaelferreira.github.io/Toten-Restaurante/", "http://localhost:5173"})
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/cadmin")
    public ResponseEntity<?> criarAdmin(@RequestBody UserRequest request) {
        userService.registrarAdmin(request);
        return ResponseEntity.status(201).body("Usuário Criado");
    }

}
