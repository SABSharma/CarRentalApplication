package com.CarRental.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Column(name ="userName" , nullable = false )
    private String userName;

    @Id
    @Column(name = "userEmail" ,nullable = false , unique = true)
    private String userEmail;

    @Column(name = "userPassword" , nullable = false , unique = true)
    private String userPassword;

    @Column(name ="proofId" , nullable = false , unique = true)
    private String proofId;

    private String role;

}
