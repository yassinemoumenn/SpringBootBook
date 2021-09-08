package com.example.SpringBootBook.service.Impl;

import com.example.SpringBootBook.model.User;

public interface IAuthenticationService {

	
	 User signInAndReturnJWT(User signInRequest);
}
