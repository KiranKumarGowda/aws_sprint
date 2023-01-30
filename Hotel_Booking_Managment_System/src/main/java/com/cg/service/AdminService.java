package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.repository.AdminRepository;
@Service
public class AdminService {
	@Autowired
	public AdminRepository adminRepository;

	public String signIn(Admin admin) {
		adminRepository.saveAndFlush(admin);
		return "admin signed in successfully";

	}

	public String signOut(Admin admin) {
		adminRepository.saveAndFlush(admin);
		return "admin SignedOut successfully";

	}

}
