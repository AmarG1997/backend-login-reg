package com.example.demo11.dto;

import com.example.demo11.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

    String message;
    User object;

    public ResponseDto(String msg, User obj) {
        this.message = msg;
        this.object = obj;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "message='" + message + '\'' +
                ", object=" + object +
                '}';
    }
}
