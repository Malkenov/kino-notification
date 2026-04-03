package com.asanali.kafka.ticket_cancelled;

import com.asanali.kafka.dto.KafkaCancelledDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaCancelledProducer {

    private final KafkaTemplate<String, KafkaCancelledDto> kafkaTemplate;


    public void send(KafkaCancelledDto dto){
        kafkaTemplate.send("ticket-cancelled",dto);
        System.out.println("Отправлено: " + dto);
    }
}
