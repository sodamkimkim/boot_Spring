package com.example.demo4_pr.controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
	//text/plain
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	// application/json
	@PostMapping("/json")
	// request요청이 있다면 --> 메시지 converter가 object mapping해줌 => object 매핑 완료되어서 나옴
	// --> method를 통해 실행됨.
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
	}
//	@PostMapping("/put")
//	public ResponseEntity<?> put(@RequestBody User user){
//		return ResponseEntity.status(HttpStatus.OK).body("aaa");
//	}
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
