package totem.pedidos.DTO;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

public record CarrinhoRequest(


       @NotBlank Long idProduto,


        @NotBlank @CPF String cpf) {
}
