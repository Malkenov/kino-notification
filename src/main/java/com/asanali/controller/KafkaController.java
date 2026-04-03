package com.asanali.controller;

import com.asanali.service.kafka.dto.KafkaCancelledDto;
import com.asanali.service.kafka.dto.KafkaPurchasedDto;
import com.asanali.service.kafka.producer.KafkaCancelledProducer;
import com.asanali.service.kafka.producer.KafkaPurchasedProducer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/notifications")
@RestController
public class KafkaController {

    private final KafkaPurchasedProducer kafkaPurchasedProducer;
    private final KafkaCancelledProducer kafkaCancelledProducer;

    @PostMapping("/ticket-purchased")
    public String sendTicket(@RequestBody KafkaPurchasedDto dto){
        kafkaPurchasedProducer.send(dto);
        return "Сообщение отправлно!";
    }

    @PostMapping("/ticket-cancelled")
    public String sendCancelled(@RequestBody KafkaCancelledDto dto){
        kafkaCancelledProducer.send(dto);
        return "Возврат в обработке!";
    }
}
