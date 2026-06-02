package totem.pedidos.Controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import totem.pedidos.DTO.PedidoRequest;
import totem.pedidos.Service.PedidoService;

import java.util.ArrayList;

@AllArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @CrossOrigin(origins = {"https://rrafaelferreira.github.io/Toten-Restaurante/", "http://localhost:5173"})
    @PostMapping("/pedir")
    public ResponseEntity<?> realizarPedido(@RequestParam String cpf) {
        pedidoService.fazerPedido(cpf);
        return ResponseEntity.status(201).body("Pedido Realizado com sucesso");
    }


}
