package totem.pedidos.Service;

import org.springframework.stereotype.Service;
import totem.pedidos.DTO.CarrinhoRequest;
import totem.pedidos.Mapper.CarrinhoMapper;
import totem.pedidos.Repository.CarrinhoRepository;
import totem.pedidos.Repository.ProdutosRepository;

import java.util.List;

@Service
public class CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    private final ProdutosRepository produtosRepository;

    public CarrinhoService(CarrinhoRepository carrinhoRepository, ProdutosRepository produtosRepository) {
        this.carrinhoRepository = carrinhoRepository;
        this.produtosRepository = produtosRepository;
    }


    public void adicionarAoCarrinho(List<CarrinhoRequest> carrinhoRequest) {

        for(CarrinhoRequest carrinho : carrinhoRequest ) {
            produtosRepository.findById(carrinho.idProduto())
                    .orElseThrow(() -> new RuntimeException("Produto Não Encontrado"));

            carrinhoRepository.save(new CarrinhoMapper().dtoToEntity(carrinho));
        }


    }




}
