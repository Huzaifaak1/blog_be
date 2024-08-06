package com.example.blog.blog.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blog.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

    public List<User> findByIsDeleted(Boolean deletedAt);
}
