package com.asanali.controller;

import com.asanali.kafka.dto.KafkaCancelledDto;
import com.asanali.kafka.dto.KafkaPurchasedDto;
import com.asanali.kafka.ticket_cancelled.KafkaCancelledProducer;
import com.asanali.kafka.ticket_purchased.KafkaPurchasedProducer;
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
