package totem.pedidos.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import totem.pedidos.DTO.ProdutoRequest;
import totem.pedidos.Entity.Produtos;
import totem.pedidos.Service.ProdutosService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutosService produtosService;


    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_ADMIN')")
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarProduto(@RequestBody ProdutoRequest request) {

        Produtos produto = produtosService.registrarProduto(request);

        return ResponseEntity.status(201).body(produto);

    }


    @CrossOrigin(origins = "*")
    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return ResponseEntity.status(200).body(produtosService.listarProdutos());
    }


}
