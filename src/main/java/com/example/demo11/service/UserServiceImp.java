package com.example.demo11.service;

import com.example.demo11.dto.LoginDto;
import com.example.demo11.dto.UserDto;
import com.example.demo11.exception.UserException;
import com.example.demo11.model.User;
import com.example.demo11.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User addUser(UserDto userDto) throws UserException {
        userDto.password = passwordEncoder.encode(userDto.password).trim();
        User user = new User(userDto);
        Optional<User> byEmailId = userRepo.findByEmail(userDto.email);
        if (byEmailId.isPresent()) {
            throw new UserException("User Already exist");
        }
        userRepo.save(user);
        return user;
    }

    @Override
    public String userLogin(LoginDto logindto) {
        Optional<User> byEmailId = userRepo.findByEmail(logindto.email);
        if (byEmailId.isPresent()&&passwordEncoder.matches(logindto.password.trim(),byEmailId.get().getPassword())){
            return "Login Successfull";
        }
        return "Incorrect email and password";
    }
}
