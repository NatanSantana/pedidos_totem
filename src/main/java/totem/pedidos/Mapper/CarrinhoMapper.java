package totem.pedidos.Mapper;

import totem.pedidos.DTO.CarrinhoRequest;
import totem.pedidos.Entity.Carrinho;

public class CarrinhoMapper {

    public Carrinho dtoToEntity(CarrinhoRequest request) {
        Carrinho carrinho = new Carrinho();

        carrinho.setCpf(request.cpf());
        carrinho.setIdProduto(request.idProduto());
        return carrinho;


    }
}
