package com.sample.user.userService.service;

import java.util.List;

import com.sample.user.userService.entity.User;

public interface UserService {

	User saveUser(User user);

	List<User> getAllUser();

	User getUser(String userId);

	void deleteUser(String userID);

	User updateUser(User user);

}
