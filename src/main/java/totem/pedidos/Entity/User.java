package totem.pedidos.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import totem.pedidos.enums.UserEnum;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    @Column(unique = true)
    private String email;

    @Getter
    @Setter
    private String senha;

    @Getter
    @Setter
    private String telefone;

    @Setter
    @Getter
    private UserEnum role;

}
