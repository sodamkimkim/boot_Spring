package com.example.demo4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo4.dto.User;

@RestController
@RequestMapping("/api")
public class ApiController {
	// text/plain
	@GetMapping("/text")
	public String text(@RequestParam String account) {
		return account;
	}
	// application/json
	@PostMapping("/json")
	// request요청이 있다면 --> 메시지 converter가 object mapping해줌 => object 매핑완료되어서 나옴. --> method를 통해 실행됨
	public User json(@RequestBody User user) {
		System.out.println(user.getName());
		return user;
		
//		private String name;
//		private int age;
////		   @JsonProperty("phone_Number")
//		private String phoneNumber;
//		private String address;
//		private String idNumber;
	}
	
	// 202, 200 -> 응답을 돌려 줄 때 응답 코드를 지정해서 보낼 수 있다.
//	@PutMapping("/put")
//	public ResponseEntity<?> put(@RequestBody User user){
//		return ResponseEntity.status(HttpStatus.OK).body("aaa");
//	}
	@PutMapping("/put")
	public ResponseEntity<User> put(@RequestBody User user){
		// ResponseEntity를 통해서 status, header등을 설정할 수 있다.
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
