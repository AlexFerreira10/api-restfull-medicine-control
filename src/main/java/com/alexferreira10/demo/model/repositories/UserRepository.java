package com.alexferreira10.demo.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.alexferreira10.demo.model.entities.user.User;

public interface UserRepository extends JpaRepository<User,Long>{

	UserDetails findByLogin(String login);
}
