package com.alexferreira10.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alexferreira10.demo.model.entities.user.User;
import com.alexferreira10.demo.config.dto.DataAuthenticationDTO;
import com.alexferreira10.demo.config.dto.DataTokenJWTDTO;
import com.alexferreira10.demo.config.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class UserAuthenticationController {

	// Spring don't injection alone, we need set up
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> login(@RequestBody @Valid DataAuthenticationDTO data) {

		// SpringDTO
		var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var authentication = manager.authenticate(token);
		
		var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());
		
		return ResponseEntity.ok(new DataTokenJWTDTO(tokenJWT));
	}
}