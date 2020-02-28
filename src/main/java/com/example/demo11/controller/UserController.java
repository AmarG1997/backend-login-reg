package com.example.demo11.controller;

import com.example.demo11.dto.LoginDto;
import com.example.demo11.dto.ResponseDto;
import com.example.demo11.dto.UserDto;
import com.example.demo11.exception.UserException;
import com.example.demo11.model.User;
import com.example.demo11.repository.UserRepo;
import com.example.demo11.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @Autowired
    UserRepo userRepo;

    @RequestMapping("/register")
    @PostMapping
    public ResponseEntity<ResponseDto> addUser(@Valid  @RequestBody UserDto userDto) throws UserException {
        User user = userService.addUser(userDto);
        ResponseDto response = new ResponseDto("user successfully registered", user);
        return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
    }

    @GetMapping
    public List getData(){
        List userRegister = userRepo.findAll();
        return userRegister;
    }

    @DeleteMapping("/{id}")
    public String  deleteData(@PathVariable int id){
        userRepo.deleteById(id);
        return "Deleted Successfully";
    }

    @RequestMapping("/login")
    @PostMapping
    public ResponseEntity userLogin(@RequestBody LoginDto login){
        String isLogin = userService.userLogin(login);
        return new ResponseEntity(isLogin,HttpStatus.OK);
    }
}