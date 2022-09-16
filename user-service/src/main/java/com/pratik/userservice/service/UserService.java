package com.pratik.userservice.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pratik.userservice.model.MyUser;
import com.pratik.userservice.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		// Logic to get the user form the Database

		MyUser user = repo.findByEmail(userName);

		return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}

	public void addUser(MyUser user) throws Exception {
//		System.out.println("--> " + user.getPassword());
//		String encodedPassword =  getPasswordDecrypted(user.getPassword());
//		System.out.println("--> " + encodedPassword);
//		user.setPassword(encodedPassword);
		repo.save(user);
	}

	public String getPasswordDecrypted(String password) throws Exception {
		if(password==null) {
			throw new Exception("password is null");
		}
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		return encodedPassword;
	}

	public MyUser getUser(String email) {
		MyUser user = repo.findByEmail(email);
		System.out.println("user :: " + user);
		return user;
	}
}
