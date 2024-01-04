package com.project.todoManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.todoManagement.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByuserName(String username);
	
	Boolean existsByEmail (String email);
	
	Optional<User> findByuserNameOrEmail (String username, String email);
	
}
