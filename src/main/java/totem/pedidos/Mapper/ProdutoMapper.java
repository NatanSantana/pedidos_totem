package totem.pedidos.Mapper;

import org.springframework.stereotype.Component;
import totem.pedidos.DTO.ProdutoRequest;
import totem.pedidos.Entity.Produtos;

@Component
public class ProdutoMapper {

    public Produtos requestToEntity(ProdutoRequest request) {
        Produtos produtos = new Produtos();
        produtos.setNomeProduto(request.nomeProduto());
        produtos.setPreco(request.preco());
        produtos.setCategoria(request.categoria());
        return produtos;
    }


}
