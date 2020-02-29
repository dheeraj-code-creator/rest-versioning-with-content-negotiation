package com.springboot.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.rest.dto.UserDto;
import com.springboot.rest.repository.UserRepository;
import com.springboot.rest.service.UserService;

@RestController
@RequestMapping(value = "/userinfo")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	// get all userinfo
	@GetMapping(value = "/alluser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> getUserinfo() {
		LOGGER.info("inside class!!!! UserController, method!!!: getUserinfo");
		return userService.getAllUserInfo();
	}

	// get user info by id
	@GetMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, "application/vnd.search.springboot-v1+json" })
	public UserDto getUserById(@PathVariable("userId") String userId) {
		LOGGER.info("inside method!!!: getUserById", userId);
		return userService.getUserByUserId(userId);
	}

	// delete existing user
	@DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteUserById(@PathVariable("userId") String userId) {
		userRepository.deleteById(userId);
	}

}
