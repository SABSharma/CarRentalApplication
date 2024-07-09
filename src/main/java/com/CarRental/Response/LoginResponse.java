package com.CarRental.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String status;

    private  String message;

    private Object object;

    public LoginResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
