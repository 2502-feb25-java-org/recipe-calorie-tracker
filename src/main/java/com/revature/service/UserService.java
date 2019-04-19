package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	public User addUser(User u) {
		if(u.getUsername() == null || u.getPassword() == null) {
			return null;
		}
		else if(userRepo.findByUsernameIgnoreCase(u.getUsername())!= null) {
			//username already exists
			return null;
		}
		else {
			return userRepo.save(u);
		}
		
	}
	
	public User login(User u) {
		if(userRepo.findByUsernameIgnoreCaseAndPassword(u.getUsername(), u.getPassword())!=null) {
			return userRepo.findByUsernameIgnoreCase(u.getUsername());
			}
		else {return null;}
	}
	public User editcalories(User u) {
		return u;
	}

}
