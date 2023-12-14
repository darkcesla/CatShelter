package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
