package com.example.blog.blog.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.blog.dtos.UserDto;
import com.example.blog.blog.entities.User;
import com.example.blog.blog.exceptions.ListingError;
import com.example.blog.blog.exceptions.NotFoundException;
import com.example.blog.blog.exceptions.UserSaveException;
import com.example.blog.blog.helper.HelperClass;
import com.example.blog.blog.repos.UserRepo;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    HelperClass helper;

    @Override
    public User getUserById(Integer id) {
        // User user = this.userRepo.findById(id);
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public Map<String, String> saveUser(UserDto userDto) {
        Map<String, String> response = new HashMap<>();
        User convertedUser = helper.userDtoToUser(userDto);
        User savedUser = this.userRepo.save(convertedUser);
        if (savedUser.getId() != null) {
            response.put("message", "success");
            return response;
        } else {
            throw new UserSaveException("Failed to save the user");
        }

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = this.userRepo.findByIsDeleted(false);
        if (users.size() != 0) {
            return users;
        } else {
            throw new ListingError("Failed to fetch users");
        }
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> user = this.userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public Map<String, String> deleteUserById(Integer id) {
        User user = this.findUserById(id);
        Map<String, String> response = new HashMap<>();
        if (user.getId() != null) {
            // this.userRepo.delete(user);
            user.setIsDeleted(true);
            this.userRepo.save(user);
            response.put("message", "User has been deleted successfully");
            return response;
        } else {
            throw new NotFoundException("User not found");
        }

    }

}
