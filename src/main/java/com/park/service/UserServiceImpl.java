package com.park.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.park.controller.User;
import com.park.repository.UserRepository;
import com.park.repository.model.Users;

@Service
public class UserServiceImpl implements UserService {
	private UserRepository repository; 
	
	//inyección por constructor
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}


	@Override
	public Integer create(User user) {
		Users entity = new Users(); 
		entity.setLastname(user.getLastname());
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPassword(user.getPassword());
		entity.setUsername(user.getUsername());
		Users response=repository.save(entity);
		return response.getId();
	}


	@Override
	public User getUser(Integer userId) {
		User response = new User(); 
		
		Optional<Users> userEntity=repository.findById(userId); 
		
		if (userEntity.isEmpty()) {
			System.out.println("No se ha encontrado un usuario con este Id");
		}
		
		Users users=userEntity.get();
		
		response.setEmail(users.getEmail());
		response.setLastname(users.getLastname());
		response.setName(users.getName());
		response.setUsername(users.getUsername());
		
		return response;
	}

}
