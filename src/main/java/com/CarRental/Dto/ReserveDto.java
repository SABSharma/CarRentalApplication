package com.CarRental.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDto {
    private Date pickupDate;
    private  Date returnDate;
    private int numberOfTravellers;
}
