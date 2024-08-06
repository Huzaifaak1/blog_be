package com.example.blog.blog.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    String name;
    String userName;
    String password;
    String bio;


    @Override
  public String toString() {
    return "name: "+name+", "+ "userName: "+userName+", bio: "+bio;
  }

}
