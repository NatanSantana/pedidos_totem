package totem.pedidos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import totem.pedidos.Entity.Carrinho;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

    List<Carrinho> findAllByCpf(String cpf);


}
