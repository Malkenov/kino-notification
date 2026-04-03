package com.asanali.service.kafka.producer;


import com.asanali.service.kafka.dto.SeatReservationExpiredDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeatExpiredProducer {

    private final KafkaTemplate<String, SeatReservationExpiredDto> kafkaTemplate;

    public void send(SeatReservationExpiredDto dto){
        kafkaTemplate.send("seat-reservation-expired",dto);
        System.out.println("Бронь истекла: " + dto);
    }
}
