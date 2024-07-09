package com.CarRental.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {

    private String carId;

    private String carModel;

    private String registrationNumber;

    private String carAvailability;

    private String brand;

    private int pricePerHour;

    private String thumbnail;
}
