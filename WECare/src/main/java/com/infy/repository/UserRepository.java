package com.infy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	public Optional<User> findByName(String name);
	public Optional<User> findByEmailAndPassword(String email,String password);
}
