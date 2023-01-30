package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.IUserRepository;

@Service
public class IUserService
{
	@Autowired
	public IUserRepository iUserRepository;
	public String addUser(User user)
	{
		iUserRepository.saveAndFlush(user);
		return "User added successfully";
	}
	public User updateUser(User user)
	{
		if(!iUserRepository.existsById(user.getUser_id())) {
		throw new UserNotFoundException("User Not Found");
		}
		else {
			User usr = iUserRepository.findById(user.getUser_id()).get();
			usr.setUser_name(user.getUser_name());
			usr.setUser_email(user.getUser_email());
			usr.setPassword(user.getPassword());
			usr.setMobile(user.getMobile());
			usr.setAddress(user.getAddress());
			iUserRepository.save(usr);
			return usr;
			
		}
	}
	public String removeUserId(int user_id)
	{
	if(iUserRepository.existsById(user_id))
	{
	iUserRepository.deleteById(user_id);
	return "User removed successfully";
	}
	else {
	throw new UserNotFoundException("User is not found with User_id:"+user_id);
	     }
    }
	public List<User>showAllUsers()
	{
		return iUserRepository.findAll();
	}
	public User showUser(int id)
	{
	return iUserRepository.findById(id).get();
	
	}
	}
