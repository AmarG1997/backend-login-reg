package com.example.demo11.model;

import com.example.demo11.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String password;

    public User(UserDto userDto) {
        this.firstName = userDto.firstName;
        this.lastName = userDto.lastName;
        this.email = userDto.email;
        this.mobileNo = userDto.mobileNo;
        this.password = userDto.password;
    }

    public User() {
    }
}
