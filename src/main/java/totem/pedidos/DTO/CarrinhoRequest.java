package totem.pedidos.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.br.CPF;

public record CarrinhoRequest(


       @NotBlank @Positive Long idProduto,


        @NotBlank @CPF String cpf) {
}
