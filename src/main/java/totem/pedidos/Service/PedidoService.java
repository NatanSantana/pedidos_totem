package totem.pedidos.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import totem.pedidos.Entity.Carrinho;
import totem.pedidos.Entity.Pedidos;
import totem.pedidos.Repository.CarrinhoRepository;
import totem.pedidos.Repository.PedidosRepository;
import totem.pedidos.Repository.ProdutosRepository;
import totem.pedidos.Repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PedidoService {

    public final PedidosRepository pedidosRepository;

    public final UserRepository userRepository;

    public final ProdutosRepository produtosRepository;

    private final CarrinhoRepository carrinhoRepository;


    public void fazerPedido(String cpf) {

        String codigoPedido = UUID.randomUUID().toString();


        List<Carrinho> produtosByCpf = carrinhoRepository.findAllByCpf(cpf);

        if (produtosByCpf == null) {
            throw new RuntimeException("Não foi possível encontrar produtos vinculados ao CPF fornecido");

        }

        for(Carrinho carrinho : produtosByCpf) {
            Pedidos entidade = new Pedidos();
            entidade.setCodigo(codigoPedido);
            entidade.setIdProduto(carrinho.getIdProduto());
            entidade.setCpf(carrinho.getCpf());
            entidade.setCriado_em(LocalDateTime.now());


            pedidosRepository.save(entidade);
        }

    }
}

