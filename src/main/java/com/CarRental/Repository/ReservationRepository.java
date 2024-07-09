package com.CarRental.Repository;


import com.CarRental.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository  extends JpaRepository<Reservation, String> {
     List<Reservation> findByUserEmail(String userEmail);
}
