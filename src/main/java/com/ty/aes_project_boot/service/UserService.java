package com.ty.aes_project_boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.aes_project_boot.dao.UserDao;
import com.ty.aes_project_boot.dto.User;
import com.ty.aes_project_boot.exception.NoSuchIdFoundException;
import com.ty.aes_project_boot.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("User detail saved Successfully");
		responseStructure.setData(userDao.saveUser(user));
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.CREATED);
		return responseEntity;
	}

	public ResponseEntity<ResponseStructure<User>> getByEmail(String email) {
		User user = userDao.getByEmail(email);
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		ResponseEntity<ResponseStructure<User>> responseEntity = new ResponseEntity<ResponseStructure<User>>(
				responseStructure, HttpStatus.OK);
		if (user != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("User Found");
			responseStructure.setData(userDao.getByEmail(email));
			return responseEntity;
		}
		throw new NoSuchIdFoundException("No user found for given id");
	}
}