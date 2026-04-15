package com.asanali.config;

public class KafkaTopicsConfig {

    private KafkaTopicsConfig() {
    } // запрет создания экземпляра

    public static final String TICKET_PURCHASED = "ticket-purchased";
    public static final String TICKET_CANCELLED = "ticket-cancelled";
    public static final String MOVIE_REMINDER = "movie-reminder";
    public static final String NEW_MOVIE_RELEASED = "new-movie-released";

    // DLQ топики - если сообщение не удалось отправить в основной топик, оно отправляется в DLQ,
    public static final String TICKET_PURCHASED_DLQ = "ticket-purchased-dlq";
    public static final String TICKET_CANCELLED_DLQ = "ticket-cancelled-dlq";
    public static final String NEW_MOVIE_RELEASED_DLQ = "new-movie-released-dlq";
}
