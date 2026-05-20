package totem.pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import totem.pedidos.Entity.Carrinho;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    @Query("""
            SELECT pr.nomeProduto, pr.preco
            FROM Carrinho ca
            JOIN Produtos pr ON ca.idProduto = pr.id
            WHERE ca.cpf = :cpf
             
            """)
    List<Carrinho> findAllByCpf(@Param("cpf") String cpf);


}
