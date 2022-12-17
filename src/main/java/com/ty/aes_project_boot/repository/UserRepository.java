package com.ty.aes_project_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.aes_project_boot.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User getByEmail(String email);

}
