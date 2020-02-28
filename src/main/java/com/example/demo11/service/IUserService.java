package com.example.demo11.service;

import com.example.demo11.dto.LoginDto;
import com.example.demo11.dto.UserDto;
import com.example.demo11.exception.UserException;
import com.example.demo11.model.User;

public interface IUserService {

    User addUser(UserDto userDto) throws UserException;
    String userLogin(LoginDto logindto);
}
