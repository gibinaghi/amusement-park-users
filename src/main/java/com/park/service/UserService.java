package com.park.service;

import com.park.controller.User;

public interface UserService {
	Integer create(User user);
	User getUser(Integer userId);
}
