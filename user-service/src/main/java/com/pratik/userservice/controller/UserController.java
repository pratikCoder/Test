package com.pratik.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pratik.userservice.model.JwtRequest;
import com.pratik.userservice.model.JwtResponse;
import com.pratik.userservice.model.MyUser;
import com.pratik.userservice.service.UserService;
import com.pratik.userservice.utility.JWTUtility;

@RestController
public class UserController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "Welcome to User Service!!";
	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

		final String token = jwtUtility.generateToken(userDetails);

		return new JwtResponse(token);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody MyUser user) throws Exception {
		userService.addUser(user);
		return ResponseEntity.ok("User Registration Successfully!!");
	}

	@GetMapping("/user")
	public ResponseEntity<?> getUser(@RequestParam String email) throws Exception {
		MyUser user = userService.getUser(email);
		return ResponseEntity.ok(user);
	}
}
