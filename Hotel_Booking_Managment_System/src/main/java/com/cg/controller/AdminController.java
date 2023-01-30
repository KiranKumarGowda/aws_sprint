package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Admin;
import com.cg.service.AdminService;

import jakarta.validation.Valid;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/signin")
	public String signIn(@RequestBody @Valid Admin admin) {
		return adminService.signIn(admin);
	}
	@GetMapping("/signout")
	public String signOut(@RequestBody Admin admin) {
		return adminService.signOut(admin);
	}

}
