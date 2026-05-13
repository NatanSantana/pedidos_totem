package totem.pedidos.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;
import totem.pedidos.enums.UserEnum;

@Data
public class UserRequest {

        @NotNull @Size(min = 5, max = 100) String nome;
        @NotNull @Email String email;
        @NotNull @CPF String cpf;
        @NotNull @Pattern(
                regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$",
                message = "A senha deve ter 8 caracteres e 1 especial e ao menos 1 número")
        String senha;
        @NotNull @Pattern(regexp = "^\\d{10,11}$", message = "Telefone inválido") String telefone;








}
