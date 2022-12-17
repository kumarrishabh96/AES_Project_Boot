package com.ty.aes_project_boot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.aes_project_boot.dto.User;
import com.ty.aes_project_boot.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}

	public Optional<User> getById(int id) {
		return userRepository.findById(id);
	}
}
