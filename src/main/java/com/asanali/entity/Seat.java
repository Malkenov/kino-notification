package com.asanali.entity;

import com.asanali.enums.SeatStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;
    private String movieId;

    @Enumerated(EnumType.STRING)
    private SeatStatus status;

    private LocalDateTime reservedUntil;
    private String userId;
}
