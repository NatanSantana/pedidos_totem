package totem.pedidos.Mapper;

import org.springframework.stereotype.Component;
import totem.pedidos.DTO.UserRequest;
import totem.pedidos.Entity.User;
import totem.pedidos.enums.UserEnum;

@Component
public class UserMapper {

    public User requestToEntity(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setSenha(request.getSenha());
        user.setNome(request.getNome());
        user.setRole(UserEnum.USER);
        return user;


    }
}
