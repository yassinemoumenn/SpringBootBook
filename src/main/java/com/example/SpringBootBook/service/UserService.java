package com.example.SpringBootBook.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBootBook.model.Role;
import com.example.SpringBootBook.model.User;
import com.example.SpringBootBook.repository.IUserRepository;
import com.example.SpringBootBook.service.Impl.IUserService;

public class UserService implements IUserService{
	  @Autowired
	    private IUserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	@Override
	public User saveUser(User user) {
		 
		        user.setPassword(passwordEncoder.encode(user.getPassword()));
		        user.setRole(Role.USER);
		        user.setCreateTime(LocalDateTime.now());

		        return userRepository.save(user);
		    }
	 @Override
	    public Optional<User> findByUsername(String username)
	    {
	        return userRepository.findByUsername(username);
	    }

	    @Override
	    @Transactional //TransactionalRequired when executing an update/delete query.
	    public void makeAdmin(String username)
	    {
	        userRepository.updateUserRole(username, Role.ADMIN);
	    }

}
