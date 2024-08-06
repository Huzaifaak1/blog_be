package com.example.blog.blog.contoller;

import org.springframework.web.bind.annotation.RestController;

import com.example.blog.blog.dtos.UserDto;
import com.example.blog.blog.entities.User;
import com.example.blog.blog.services.UserService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController()
@RequestMapping("/users") // To put the generic endpoint
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public Map<String, String> saveUser(@RequestBody() UserDto userDto) {
        // List<User> allUsers = this.userService.getAllUsers();
        // if(allUsers.size() ==0)

        Map<String, String> response = this.userService.saveUser(userDto);
        return response;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        int userId = Integer.parseInt(id);
        User user = this.userService.findUserById(userId);
        return new ResponseEntity<User>(user, HttpStatus.FOUND);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteUserById(@PathVariable("id") String id) {
        int userId = Integer.parseInt(id);
        Map<String, String> response = this.userService.deleteUserById(userId);
        return response;

    }
}
