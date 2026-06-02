package totem.pedidos.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import totem.pedidos.DTO.CarrinhoRequest;
import totem.pedidos.Service.CarrinhoService;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }

    @CrossOrigin(origins = {"https://rrafaelferreira.github.io/Toten-Restaurante/", "http://localhost:5173"})
    @PostMapping()
    public ResponseEntity<?> adicionarProdutosAoCarrinho(@RequestBody List<CarrinhoRequest> request) {

        carrinhoService.adicionarAoCarrinho(request);

        return ResponseEntity.status(200).body("Produto Adicionado ao carrinho");

    }

    @CrossOrigin(origins = {"https://rrafaelferreira.github.io/Toten-Restaurante/", "http://localhost:5173"})
    @GetMapping()
    public ResponseEntity<?> listarProdutosByCpf(@RequestParam String cpf) {
        return ResponseEntity.ok().body(carrinhoService.resgatarCarrinhoByCpf(cpf));
    }

}
