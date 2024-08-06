package com.example.blog.blog.services;

import java.util.List;
import java.util.Map;

import com.example.blog.blog.dtos.UserDto;
import com.example.blog.blog.entities.User;

public interface UserService {

    User getUserById(Integer id);

    Map<String,String> saveUser(UserDto userDto);

    List<User> getAllUsers();

    User findUserById(Integer id);

    Map<String,String> deleteUserById(Integer id);

}
