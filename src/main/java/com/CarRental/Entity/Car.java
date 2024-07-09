package com.CarRental.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "carId" , nullable = false , unique = true)
    private String carId;

    @Column(name ="carModel" ,unique = true , nullable = false)
    private String carModel;

    @Column(name = "registrationNumber" , unique = true , nullable = false)
    private String registrationNumber;

    @Column(name = "carAvailability" , nullable = false )
    private String carAvailability;

    @Column(name = "brand" ,nullable = false)
    private String brand;

    @Column(name = "pricePerHour" ,  nullable = false)
    private int pricePerHour;

    @Column(name = "thumbnail" ,nullable = false)
    private String thumbnail;
}
