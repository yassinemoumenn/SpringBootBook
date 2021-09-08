package com.example.SpringBootBook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.example.SpringBootBook.model.User;
import com.example.SpringBootBook.security.UserPrincipal;
import com.example.SpringBootBook.security.jwt.IJwtProvider;
import com.example.SpringBootBook.service.Impl.IAuthenticationService;



public class AuthenticationService implements IAuthenticationService{

	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private IJwtProvider jwtProvider;
	    
	    
	    @Override
	    public User signInAndReturnJWT(User signInRequest)
	    {
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
	        );

	        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
	        String jwt = jwtProvider.generateToken(userPrincipal);

	        User signInUser = userPrincipal.getUser();
	        signInUser.setToken(jwt);

	        return signInUser;
	    }

}
