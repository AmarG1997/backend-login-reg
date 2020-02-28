package com.example.demo11.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserDto {
    @NotNull
    @Length(min = 2, max = 10, message = "Invalid Name")
    public String firstName;
    @NotNull
    @Length(min = 2, max = 10, message = "Invalid Name")
    public String lastName;
    @Email
    public String email;
    public String mobileNo;
    public String password;
}
