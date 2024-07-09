package com.CarRental.Utility;

import com.CarRental.Dto.CarDto;
import com.CarRental.Dto.ReservationDto;
import com.CarRental.Dto.UserDto;
import com.CarRental.Entity.Car;
import com.CarRental.Entity.Reservation;
import com.CarRental.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class MapperUtility {

    @Bean
    static ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public  static User maptoUser(UserDto userdto){
        return modelMapper().map(userdto , User.class);
    }

    public  static  UserDto maptoUserDto(User user){
        return  modelMapper().map(user, UserDto.class);
    }

    // For car
    public  static Car maptoCar(CarDto carDto){
        return modelMapper().map(carDto , Car.class);
    }

    public static  CarDto maptoCarDto(Car car){
        return  modelMapper().map(car ,CarDto.class);
    }

    // for reservation
    public  static Reservation maptoReservation(ReservationDto reservationDto){
        return  modelMapper().map(reservationDto , Reservation.class);
    }

    public  static  ReservationDto maptoReservationDto(Reservation reservation){
        return modelMapper().map(reservation , ReservationDto.class);
    }
}
