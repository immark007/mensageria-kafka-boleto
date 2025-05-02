package br.com.mark.api_boleto.service.kafka;

import br.com.mark.avro.Boleto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoletoProducer {
    @Value("${spring.kafka.topics.boleto}")
    public String topico;
    private final KafkaTemplate<String, Boleto> kafkaTemplate;

    public void enviarMensagem(Boleto boleto){
        kafkaTemplate.send(topico, boleto);
    }
}
