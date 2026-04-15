package com.asanali.config;

import org.apache.kafka.common.TopicPartition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.util.backoff.FixedBackOff;

@Configuration
public class KafkaConfig {

    @Bean
    public DefaultErrorHandler errorHandler(KafkaTemplate<Object, Object> template) {

        DeadLetterPublishingRecoverer recoverer = new DeadLetterPublishingRecoverer(
                template,
                (record, ex) -> new TopicPartition(
                        record.topic() + "-dlq", // мой формат dlq
                        record.partition()
                )

        );

        FixedBackOff backOff = new FixedBackOff(1000L, 3);
        // retry - 3 попытки, пауза - 1 сек, переброс на DLQ, после 3 раза

        return new DefaultErrorHandler(recoverer, backOff);
    }
}