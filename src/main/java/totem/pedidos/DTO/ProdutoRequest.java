package totem.pedidos.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProdutoRequest(

        @NotBlank
        @Size(min = 5, message = "O nome do produto deve ter pelo menos 5 caracteres")
        String nomeProduto,

        @NotNull
        @Positive
        BigDecimal preco

)


{

    @Override
    public String toString() {
        return "[NOME]: "+nomeProduto+" [PREÇO]"+preco;
    }
}
