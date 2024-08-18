package com.alexferreira10.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.alexferreira10.demo.model.entities.user.UserRepository;

@Service
public class UserAuthenticationService implements UserDetailsService{
//Spring understands that this is the authentication class
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByLogin(username);
	}
}