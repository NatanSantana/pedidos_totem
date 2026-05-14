package totem.pedidos.Service;

import org.springframework.stereotype.Service;
import totem.pedidos.DTO.CarrinhoRequest;
import totem.pedidos.Exception.UserDoesntExist;
import totem.pedidos.Mapper.CarrinhoMapper;
import totem.pedidos.Repository.CarrinhoRepository;
import totem.pedidos.Repository.ProdutosRepository;
import totem.pedidos.Repository.UserRepository;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    private final ProdutosRepository produtosRepository;

    private final UserRepository userRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutosRepository produtosRepository, UserRepository userRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtosRepository = produtosRepository;
        this.userRepository = userRepository;
    }


    public void adicionarAoCarrinho(List<CarrinhoRequest> carrinhoRequest) {

        for(CarrinhoRequest carrinho : carrinhoRequest ) {

            userRepository.findByCpf(carrinho.cpf()).orElseThrow(() -> new UserDoesntExist("Não foi possível encontrar um usuário com esse CPF"));

            produtosRepository.findById(carrinho.idProduto())
                    .orElseThrow(() -> new RuntimeException("Produto Não Encontrado"));

            carrinhoRepository.save(new CarrinhoMapper().dtoToEntity(carrinho));
        }


    }




}
