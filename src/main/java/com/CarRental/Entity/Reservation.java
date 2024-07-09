package com.CarRental.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reservation")
public class Reservation {

    @Id
    @Column(name = "bookingId" ,unique = true ,nullable = false)
    private String bookingId;

    @Column(name = "userEmail"  , nullable = false)
    private String userEmail;

    @Column(name = "carId"  , nullable = false)
    private String carId;

    @Column(name = "reservationDate" ,  nullable = false)
    private Date reservationDate;

    @Column(name = "pickupDate" , nullable = false)
    private Date pickupDate;

    @Column(name = "returnDate" ,nullable = false)
    private Date returnDate;

    @Column(name = "numberOfTravellers" ,nullable = false)
    private int numberOfTravellers;

    @Column(name = "status" , nullable = false )
    private String status;

    @Column( name = "car",nullable = false)
    private String car;

    @Column(name ="img" , nullable = false)
    private String img;

    @Column(name = "total" , nullable = false)
    private int total;
}
