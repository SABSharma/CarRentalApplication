package com.CarRental.Service;

import com.CarRental.Dto.LoginDto;
import com.CarRental.Dto.UserDto;
import com.CarRental.Exception.ResourceNotFoundexception;
import com.CarRental.Response.UserRegisterResponse;
import com.CarRental.Entity.User;
import com.CarRental.Repository.UserRepository;
import com.CarRental.Response.LoginResponse;
import com.CarRental.Utility.MapperUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public UserRegisterResponse registerUser(UserDto userDto) {
//        User user1 = MapperUtility.maptoUser(userDto);
         if(userRepository.existsById(userDto.getUserEmail()) ){
             throw  new ResourceNotFoundexception("this email addess is laready Registered","Email" ,userDto.getUserEmail());
         }
         User user = new User();
         user.setUserName(userDto.getUserName());
         user.setUserEmail(userDto.getUserEmail());
        // user.setUserPassword(userDto.getUserPassword());
         user.setUserPassword(passwordEncoder.encode(userDto.getUserPassword()));
         user.setProofId(userDto.getProofId());

         //user.setRole("ROLE_USER");
         user.setRole("ROLE_ADMIN");

        Optional<User> save = Optional.of(userRepository.save(user));
        if(save.isPresent()){
            return  new UserRegisterResponse("Sucess" ,"Users registered sucessfuly");
        }

        return new UserRegisterResponse("Failure" , "User registeration is Unsucessfull");
    }

    @Override
    public LoginResponse loginUser(LoginDto loginDto) {
        Optional<User> findbyUserEmail = userRepository.findById(loginDto.getUserEmail());
        LoginResponse loginResponse = new LoginResponse();
        if(findbyUserEmail.isPresent()){
            if(loginDto.getUserEmail().equals(findbyUserEmail.get().getUserEmail())  &&
                loginDto.getUserPassword().equals(findbyUserEmail.get().getUserPassword())){
  //                   loginResponse.setMessage("Sucess");
 //                    loginResponse.setMessage("Lofin Succed");
                    UserDto userDto = new UserDto();
                    userDto.setUserName(findbyUserEmail.get().getUserName());
                    userDto.setUserEmail(findbyUserEmail.get().getUserEmail());
                    userDto.setProofId(findbyUserEmail.get().getProofId());

                    return  new LoginResponse("Sucess" , "Login Succeded" , userDto);
            }

        }
        return new LoginResponse("Failed" ,"Incorrect Username And Password" );
    }

    @Override
    public LoginResponse loginAuth(LoginDto loginDto) {
        Authentication authenticate =
                authenticationManager.
                        authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserEmail(), loginDto.getUserPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return new LoginResponse("sucess" , "Login Sucessfull" , null);
    }
}
