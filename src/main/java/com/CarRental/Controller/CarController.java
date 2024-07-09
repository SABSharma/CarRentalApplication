package com.CarRental.Controller;

import com.CarRental.Dto.CarDto;
import com.CarRental.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/AddCar")
    public ResponseEntity<CarDto> AddCar( @RequestBody CarDto dto){

        return new ResponseEntity<>(carService.addCar(dto) , HttpStatus.ACCEPTED);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/listCars")
    public  ResponseEntity<List<CarDto>> listAllCars(){
        return  new ResponseEntity<>(carService.listAllCars() ,HttpStatus.OK);
    }
}
