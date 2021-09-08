package com.example.SpringBootBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.SpringBootBook.model.User;
import com.example.SpringBootBook.service.Impl.IAuthenticationService;
import com.example.SpringBootBook.service.Impl.IUserService;

public class AuthenticationController {
	
	
	 @Autowired
	    private IAuthenticationService authenticationService;

	    @Autowired
	    private IUserService userService;

	    @PostMapping("sign-up") //api/authentication/sign-up
	    public ResponseEntity<?> signUp(@RequestBody User user)
	    {
	        if (userService.findByUsername(user.getUsername()).isPresent())
	        {
	            return new ResponseEntity<>(HttpStatus.CONFLICT);
	        }
	        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
	    }

	    @PostMapping("sign-in")//api/authentication/sign-in
	    public ResponseEntity<?> signIn(@RequestBody User user)
	    {
	        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
	    }
	}