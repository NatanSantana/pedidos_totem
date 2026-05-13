package totem.pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import totem.pedidos.Entity.Pedidos;

import java.util.List;

@Repository
public interface PedidosRepository  extends JpaRepository<Pedidos, Long> {

    @Query("""
            SELECT DISTINCT u.email
            FROM Pedidos p
            JOIN User u ON p.cpf = u.cpf
            
            """)
    List<String> emailsUsers();

}
