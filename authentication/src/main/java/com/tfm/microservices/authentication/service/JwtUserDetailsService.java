package com.tfm.microservices.authentication.service;

import com.tfm.microservices.authentication.model.UserData;
import com.tfm.microservices.authentication.model.UserRepository;
import com.tfm.microservices.authentication.pojo.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData userData = userRepository.findByUsername(username);
		if (userData == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new User(userData.getUsername(), userData.getPassword(),
				new ArrayList<>());
	}
	
	public UserData save(UserRequest user) {
		UserData newUser = new UserData();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(newUser);
	}
}