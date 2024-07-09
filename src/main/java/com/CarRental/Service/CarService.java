package com.CarRental.Service;


import com.CarRental.Dto.CarDto;

import java.util.List;

public interface CarService {
     CarDto addCar(CarDto carDto);

     List<CarDto> listAllCars();
}
