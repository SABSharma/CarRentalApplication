package com.CarRental.Controller;

import com.CarRental.Dto.ReservationDto;
import com.CarRental.Dto.ReserveDto;
import com.CarRental.Response.ReservationResponse;
import com.CarRental.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarReserve {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reserve")
   public ResponseEntity<ReservationDto> reserveCar(@RequestBody ReservationDto reservationDto){

        return  new ResponseEntity<>(reservationService.reservecar(reservationDto) , HttpStatus.OK) ;

   }

   @PostMapping("my-bookings/{userEmail}")
   public  ResponseEntity<ReservationResponse> myBooking(@PathVariable("userEmail") String userEmail ){

        return  new ResponseEntity<>(reservationService.listOfBookings(userEmail),HttpStatus.OK);

   }

   @DeleteMapping("/cancelBooking/{bookingId}")
   public  ResponseEntity<String> canelBooking( @PathVariable("bookingId") String bookingId){
        return  new ResponseEntity<>(reservationService.deleteBooking(bookingId),HttpStatus.OK);
   }
}
