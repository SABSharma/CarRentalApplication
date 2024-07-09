package com.CarRental.Service;

import com.CarRental.Dto.LoginDto;
import com.CarRental.Dto.UserDto;
import com.CarRental.Response.UserRegisterResponse;
import com.CarRental.Response.LoginResponse;

public interface UserService {
   UserRegisterResponse registerUser(UserDto user);

   LoginResponse loginUser(LoginDto userDto);

   LoginResponse loginAuth(LoginDto loginDto);
}
