package totem.pedidos.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import totem.pedidos.DTO.ProdutoRequest;
import totem.pedidos.Entity.Produtos;
import totem.pedidos.Mapper.ProdutoMapper;
import totem.pedidos.Repository.ProdutosRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final ProdutoMapper produtoMapper;

    public Produtos registrarProduto(ProdutoRequest request) {

        if (produtosRepository.findByNomeProduto(request.nomeProduto()).isPresent() ) {
            log.error("Produto já existe");
            throw new IllegalArgumentException("Já existe um produto com esse nome");
        }

        Produtos produto = produtoMapper.requestToEntity(request);


        produtosRepository.save(produto);
        log.info("Produto criado: " + request);
        return produto;
    }

    public List<Produtos> listarProdutos() {
        return produtosRepository.findAll();
    }







}
