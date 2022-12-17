package com.ty.aes_project_boot.dto;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.ty.aes_project_boot.AesProjectBootApplication;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Convert(converter = AesProjectBootApplication.class)
	private String email;
	@NotNull
	@Convert(converter = AesProjectBootApplication.class)
	private String password;

}
