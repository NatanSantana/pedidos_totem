package totem.pedidos.Mensageria;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import totem.pedidos.DTO.PedidoReponse;

import java.util.List;

@RequiredArgsConstructor
@Component
public class KafkaSender {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageKf(String topico, String response) {

        kafkaTemplate.send(topico, response);
    }

}
