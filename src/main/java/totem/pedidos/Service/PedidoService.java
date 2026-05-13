package totem.pedidos.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;
import totem.pedidos.DTO.PedidoReponse;
import totem.pedidos.DTO.PedidoRequest;
import totem.pedidos.Entity.Carrinho;
import totem.pedidos.Entity.Pedidos;
import totem.pedidos.Entity.Produtos;
import totem.pedidos.Entity.User;
import totem.pedidos.Exception.NullNomeProduto;
import totem.pedidos.Mapper.PedidoMapper;
import totem.pedidos.Mensageria.KafkaSender;
import totem.pedidos.Repository.CarrinhoRepository;
import totem.pedidos.Repository.PedidosRepository;
import totem.pedidos.Repository.ProdutosRepository;
import totem.pedidos.Repository.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PedidoService {

    public final PedidosRepository pedidosRepository;

    public final UserRepository userRepository;

    public final ProdutosRepository produtosRepository;

    public final KafkaSender kafkaSender;

    private final ObjectMapper objectMapper;

    private final CarrinhoRepository carrinhoRepository;


    public void fazerPedido(String cpf) {

        String codigoPedido = UUID.randomUUID().toString();


        List<Carrinho> produtosByCpf = carrinhoRepository.findAllByCpf(cpf);

        if (produtosByCpf == null) {
            throw new RuntimeException("Não foi possível encontrar produtos vinculados ao CPF fornecido");

        }

        for(Carrinho carrinho : produtosByCpf) {
            Pedidos entidadePedido = new Pedidos();
            entidadePedido.setCodigo(codigoPedido);
            entidadePedido.setIdProduto(carrinho.getIdProduto());
            entidadePedido.setCpf(carrinho.getCpf());
            entidadePedido.setCriado_em(LocalDateTime.now());


            pedidosRepository.save(entidadePedido);
        }

    }
}

