package com.asanali.repository;

import com.asanali.entity.Seat;
import com.asanali.enums.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    // ищет все истекшие брони
    List<Seat> findByStatusAndReservedUntilBefore(SeatStatus status, LocalDateTime now);
}
