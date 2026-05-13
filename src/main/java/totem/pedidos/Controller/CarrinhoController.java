package totem.pedidos.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping()
    public ResponseEntity<?> adicionarProdutosAoCarrinho(@RequestBody List<CarrinhoRequest> request) {

        carrinhoService.adicionarAoCarrinho(request);

        return ResponseEntity.status(200).body("Produto Adicionado ao carrinho");

    }

}
