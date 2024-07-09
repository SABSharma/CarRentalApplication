package com.CarRental.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationDto {
    private String bookingId;

    private String userEmail;

    private String carId;

    private Date reservationDate;

    private Date pickupDate;

    private Date returnDate;

    private int numberOfTravellers;

    private String status;

    private String car;

    private String img;

    private int total;
}
