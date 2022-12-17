package com.ty.aes_project_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.aes_project_boot.dto.User;
import com.ty.aes_project_boot.service.UserService;
import com.ty.aes_project_boot.util.ResponseStructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@ApiOperation(value = "Save User", notes = "It is used to save user")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal server Error"),
			@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 200, message = "ok") })
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_ATOM_XML_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
}
