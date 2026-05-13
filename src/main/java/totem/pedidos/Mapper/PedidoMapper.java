package totem.pedidos.Mapper;

import org.springframework.stereotype.Component;
import totem.pedidos.DTO.PedidoRequest;
import totem.pedidos.Entity.Pedidos;

import java.util.UUID;

@Component
public class PedidoMapper {

    public Pedidos requestToEntity(PedidoRequest request) {
        Pedidos pedidos = new Pedidos();


        pedidos.setCpf(request.cpf());

        return pedidos;


    }


}
