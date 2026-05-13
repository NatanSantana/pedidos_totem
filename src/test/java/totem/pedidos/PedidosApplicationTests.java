package totem.pedidos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import totem.pedidos.Repository.PedidosRepository;

import java.util.List;

@SpringBootTest
class PedidosApplicationTests {

    @Autowired
    private PedidosRepository pedidosRepository;


    @Test
	void contextLoads() {
        List<String> emails = pedidosRepository.emailsUsers();

        emails.stream().forEach(System.out::println);



	}

}
