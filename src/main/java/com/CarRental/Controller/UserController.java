package com.CarRental.Controller;

import com.CarRental.Dto.LoginDto;
import com.CarRental.Dto.UserDto;
import com.CarRental.Response.UserRegisterResponse;
import com.CarRental.Response.LoginResponse;
import com.CarRental.Security.CarUserDetails;
import com.CarRental.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CarUserDetails carUserDetails;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@Valid  @RequestBody UserDto userDto){

        return new ResponseEntity<>(userService.registerUser(userDto) , HttpStatus.OK);
    }

    @PostMapping("/login")
    public  ResponseEntity<LoginResponse> loginResponse(@Valid @RequestBody LoginDto loginDto){

        return new ResponseEntity<>( userService.loginUser(loginDto) ,HttpStatus.OK);
    }

    @PostMapping("/loginWithSecurity/login")
    public ResponseEntity<LoginResponse> loginWithSecurity(@Valid @RequestBody LoginDto loginDto) throws  Exception{

        return  new ResponseEntity<>(userService.loginAuth(loginDto) , HttpStatus.OK);
    }

}
