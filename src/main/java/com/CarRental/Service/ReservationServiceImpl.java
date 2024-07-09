package com.CarRental.Service;

import com.CarRental.Dto.CarDto;
import com.CarRental.Dto.Data;
import com.CarRental.Dto.ReservationDto;
import com.CarRental.Entity.Car;
import com.CarRental.Entity.Reservation;
import com.CarRental.Entity.User;
import com.CarRental.Exception.ResourceNotFoundexception;
import com.CarRental.Repository.CarRepository;
import com.CarRental.Repository.ReservationRepository;
import com.CarRental.Repository.UserRepository;
import com.CarRental.Response.ReservationResponse;
import com.CarRental.Utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements  ReservationService{
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarRepository carRepository;
    @Override
    public ReservationDto reservecar(ReservationDto reservationDto) {
        Reservation reservation = MapperUtility.maptoReservation(reservationDto);
        // Checking the CarId And User email
        Optional<Car> carId = carRepository.findById(reservation.getCarId());
        if(carId.isEmpty()){
            throw  new ResourceNotFoundexception("Does not exists" ,"CarId",reservationDto.getCarId());
        }
        Optional<User> userEmail = userRepository.findById(reservation.getUserEmail());
        if(userEmail.isEmpty()){
            throw  new ResourceNotFoundexception("Does not exists" ,"UserEmail",reservationDto.getUserEmail());
        }
        reservationRepository.save(reservation);

        return MapperUtility.maptoReservationDto(reservation);
    }

    @Override
    public ReservationResponse listOfBookings(String userEmail) {

        List<Reservation > bookings = reservationRepository.findByUserEmail(userEmail);
        if(bookings.isEmpty()){
            throw  new ResourceNotFoundexception("Does not exists" ,"email" ,userEmail);
        }
        ReservationResponse reservationResponse = new ReservationResponse();
        Data data = new Data();
        data.setBookings(bookings);
        reservationResponse.setStatus("Sucess" );
        reservationResponse.setMessage("List of Bookings");
        reservationResponse.setData(data);
        return reservationResponse;
    }

    @Override
    public String deleteBooking(String bookingId) {
         reservationRepository.findById(bookingId).orElseThrow(
        ()-> new ResourceNotFoundexception("Not exists" ,"bookingId" ,bookingId)
    );
         reservationRepository.deleteById(bookingId);
         return "Booking got deleted";
    }
}
