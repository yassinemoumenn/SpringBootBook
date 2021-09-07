package com.example.SpringBootBook.service.Impl;

import java.util.Optional;

import com.example.SpringBootBook.model.User;


public interface IUserService {
	User saveUser(User user);

    Optional<User> findByUsername(String username);

    void makeAdmin(String username);
}
