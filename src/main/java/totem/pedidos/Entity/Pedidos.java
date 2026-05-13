package totem.pedidos.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String codigo;

    @Getter
    @Setter
    private Long idProduto;

    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private LocalDateTime criado_em;




}
