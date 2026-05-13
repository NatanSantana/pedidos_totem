package totem.pedidos.DTO;

import java.math.BigDecimal;

public record PedidoReponse(String nomeProduto, BigDecimal preco, String email, String codigo) {
}
