package totem.pedidos.Mapper;

import totem.pedidos.DTO.UserRequest;
import totem.pedidos.Entity.User;
import totem.pedidos.enums.UserEnum;

public class AdminMapper {

    public User requestToEntity(UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setSenha(request.getSenha());
        user.setNome(request.getNome());
        user.setRole(UserEnum.ADMIN);
        return user;


    }
}
