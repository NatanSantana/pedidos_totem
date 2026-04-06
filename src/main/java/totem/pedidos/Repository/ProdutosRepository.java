package totem.pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import totem.pedidos.Entity.Produtos;

import java.util.Optional;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    boolean existsByNomeProduto(String nomeProduto);
}
