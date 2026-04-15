package com.asanali.service.kafka.consumer;

import com.asanali.config.KafkaTopicsConfig;
import com.asanali.dto.NewMovieReleasedDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NewMovieReleasedConsumer {

    private final JavaMailSender mailSender;

    @KafkaListener(topics = KafkaTopicsConfig.NEW_MOVIE_RELEASED, groupId = "notification-group")
    public void listen(NewMovieReleasedDto dto) {


        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(dto.getUserEmail());
        message.setSubject("Новый фильм: " + dto.getMovieName());
        message.setText(
                "Привет " + dto.getUserName() + "!\n\n" +
                        "Вышел новый фильм: " + dto.getMovieName() + "\n" +
                        "Жанр: " + dto.getGenre() + "\n" +
                        "Дата выхода: " + dto.getReleaseDate() + "\n" +
                        "Кинотеатр: " + dto.getCinemaName()
        );
        mailSender.send(message);
        log.info("Сообщение отправлена на {}", dto.getUserEmail());

    }
}
