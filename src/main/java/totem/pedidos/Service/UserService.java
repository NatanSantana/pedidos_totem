package totem.pedidos.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import totem.pedidos.DTO.UserRequest;
import totem.pedidos.Entity.User;
import totem.pedidos.Exception.ExistingEmailException;
import totem.pedidos.Mapper.UserMapper;
import totem.pedidos.Repository.UserRepository;
import totem.pedidos.Security.SecurityConfig;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final SecurityConfig securityConfig;
    private final PasswordEncoder passwordEncoder;

    /*
        Parâmetros validados no request:
        nome: tamanho entre 5 e 100
        email: validação @email
        senha: regex exigindo 8 caracteres e 1 especial e 1 número
        telefone: somente dígitos de no máximo 11 caracteres

     */
    public User registrarUser(UserRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ExistingEmailException("Já existe uma conta com esse email");
        }


        request.setSenha(passwordEncoder.encode(request.getSenha()));
        return userRepository.save(new UserMapper().requestToEntity(request));
    }

    public User registrarAdmin(UserRequest request) {
        request.setSenha(passwordEncoder.encode(request.getSenha()));
        return userRepository.save(new UserMapper().requestToEntity(request));
    }


}
