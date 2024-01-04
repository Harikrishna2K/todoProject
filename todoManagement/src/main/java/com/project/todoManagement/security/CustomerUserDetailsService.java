package com.project.todoManagement.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.todoManagement.entity.User;
import com.project.todoManagement.repository.UserRepository;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	 * Here we are getting the user from the database and granting the 
	 * authorities by specifying the role
	 * 
	 * */

	@Override
	public UserDetails loadUserByUsername(String usernameorEmail) throws UsernameNotFoundException {
		
		/*
		 * This set of code retreives the user from the database
		 * */
		
		User user = userRepository.findByuserNameOrEmail(usernameorEmail, usernameorEmail)
				.orElseThrow(() -> new UsernameNotFoundException("User not existed by username or email"));
		
		
		Set<GrantedAuthority> authorities = user.getRoles().stream()
									.map((role) -> new SimpleGrantedAuthority(role.getName()))
									.collect(Collectors.toSet());
		
		
		/*
		 * Provided by spring security , this user object so we are using it and authorizing it with
		 * our user object
		 * 
		 * 
		 * */
		
		return new org.springframework.security.core.userdetails.User(
				usernameorEmail,
				user.getPassword(),
				authorities
				
				
				
				);
	}
	
	
	
	
}
