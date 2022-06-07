package com.example.exception_2.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception_2.dto.User;

@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

	//http://localhost:9090/api/user
	@GetMapping("/user")
	public User user(@Size(min = 2, max = 20) @RequestParam(required = true) String name,
			@NotNull
			@Min(1)
			@RequestParam(required = true) Integer age) {
		int mAge = age + 10;
		User user = new User();
		user.setName(name);
		user.setAge(mAge);
		return user;
	}

	//http://localhost:9090/api/user
	@PostMapping("/user")
	public User user(@Valid @RequestBody User user) {
		return user;

	}

}
