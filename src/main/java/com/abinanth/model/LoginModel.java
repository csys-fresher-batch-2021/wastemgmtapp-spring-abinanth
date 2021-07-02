package com.abinanth.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
	@NotEmpty(message = "Name cannot be empty")
	// @Size(min = 3, max = 20, message = "Name must be between 3 and 20
	// characters")
	private String userName;
	@NotNull
	// @Size(min = 8, max = 30, message = "Password must be greater than 8 and less
	// than 30 characters with altleast 1 Capital leter and 1 numneric")
	private String password;
}
