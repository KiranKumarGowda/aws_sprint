package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController
public class IUserController {
	@Autowired
	private IUserService iUserService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		return iUserService.addUser(user);
	}

	@GetMapping("/showAllUsers")
	public List<User> showAllUsers() {
		return iUserService.showAllUsers();
	}

	@GetMapping("/showUser/{id}")
	public User showUser(@PathVariable("id") int user_id) {
		return iUserService.showUser(user_id);
	}

	@GetMapping("/removeUser")
	public String removeUser(@PathVariable("id") int user_id) {
		return iUserService.removeUserId(user_id);
	}
	
	 @PutMapping("/updateUser") 
	 public User updateUser(@RequestBody User user) {
	 return iUserService.updateUser(user); 
	  }
	 
}
