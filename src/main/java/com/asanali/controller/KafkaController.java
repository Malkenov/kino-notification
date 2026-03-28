package com.asanali.controller;

import com.asanali.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/notifications")
@RestController
public class KafkaController {

    private final KafkaProducerService producerService;

    @PostMapping
    public String send(@RequestParam String message){
        producerService.sendMessage(message);
        return "Сообщение отправлно!";
    }
}
