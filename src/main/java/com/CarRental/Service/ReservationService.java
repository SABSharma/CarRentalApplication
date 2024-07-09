package com.CarRental.Service;


import com.CarRental.Dto.ReservationDto;
import com.CarRental.Response.ReservationResponse;

public interface ReservationService {
      ReservationDto reservecar(ReservationDto reservationDto);

      ReservationResponse listOfBookings(String userEmail);

      String deleteBooking(String bookingId);
}
