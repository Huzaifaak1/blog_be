package com.example.blog.blog.helper;

import org.springframework.stereotype.Component;

import com.example.blog.blog.dtos.UserDto;
import com.example.blog.blog.entities.User;

@Component
public class HelperClass {
    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        System.out.println("bio : " + userDto.getBio());
        user.setName(userDto.getName());
        user.setBio(userDto.getBio());
        user.setUserName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        return user;
    }
}
