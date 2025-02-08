package com.sample.user.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.user.userService.entity.User;
import com.sample.user.userService.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") String id) {

		User user = userService.getUser(id);
		return ResponseEntity.ok(user);

	}

	@GetMapping("/allUser")
	public ResponseEntity<List<User>> getAllUser() {

		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser);

	}

	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		log.info("inside the save user ");
		User allUser = userService.saveUser(user);

		return ResponseEntity.status(HttpStatus.CREATED).body(allUser);

	}

}
