package com.kodnest.tunehub.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.tunehub.entity.User;
import com.kodnest.tunehub.repository.SongRepository;
import com.kodnest.tunehub.repository.UserRepositorry;
import com.kodnest.tunehub.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositorry userRepository;
	
	@Autowired
	SongRepository songRepository;

	public String addUser(User user) {
		userRepository.save(user);
		return "!!!!User Added successfully!!!!";
	}


	//to check the duplicate entries
	@Override
	public boolean emailExists(String email) {
		if(userRepository.findByEmail(email)!=null) {
			return true;
		}
		else {
			return false;		
		}
	}


	@Override
	public boolean validateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		String dbpwd = user.getPassword();
		if(user!=null && password.equals(dbpwd)) {
			return true;		
		}
		else {
			return false;
		}
	}


	@Override
	public String getRole(String email) {
		User user = userRepository.findByEmail(email);
		return user.getRole();
	}


	@Override
	public User getUser(String email) {
		return userRepository.findByEmail(email);
	}


	@Override
	public void updateUser(User user) {
		userRepository.save(user);
	}

}
