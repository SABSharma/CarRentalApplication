package com.CarRental.Service;

import com.CarRental.Dto.CarDto;
import com.CarRental.Entity.Car;
import com.CarRental.Repository.CarRepository;
import com.CarRental.Utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements  CarService{

    @Autowired
    private CarRepository carRepository;
    @Override
    public CarDto addCar(CarDto carDto) {
        Car car = MapperUtility.maptoCar(carDto);
        Car savecar = carRepository.save(car);

        return MapperUtility.maptoCarDto(savecar);
    }

    @Override
    public List<CarDto> listAllCars() {
        List<Car> allCars = carRepository.findAll();
        List<CarDto> listOfCarDto = allCars.stream().map(e -> MapperUtility.maptoCarDto(e)).collect(Collectors.toList());

        return listOfCarDto;
    }
}
