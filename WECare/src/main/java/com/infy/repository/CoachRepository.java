package com.infy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Coach;

public interface CoachRepository extends JpaRepository<Coach,Integer>{
	public Optional<Coach> findByName(String name);
	public Optional<Coach> findByCoachIdAndPassword(Integer coachId,String password);
}
