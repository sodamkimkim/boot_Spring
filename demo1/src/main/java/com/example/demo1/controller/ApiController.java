package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller는.. 주소를 만들어주는 역할
// 주소체계를 만들어 보자.
@RestController
@RequestMapping("/api/get")
public class ApiController {

	// URL : 자원 요청하는 주소 체계방식
	// URI : 식별자 방식
	// http://localhost:9090/api/hello
	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayhello";
	}
	// path-variable방식
	// get -> URI방식 사용(데이터를 담아서 요청) // 처리를 하고 응답을 해줄수 있다.
	//http://localhost:9090/api/get/path-variable/[xxx]
	@GetMapping(path="/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {
		System.out.println("브라우저에서 들어온 값을 받음 : "+name);
		return "[["+name+"]]";
	}
	//http://localhost:9090/api/get/path-variable/[xxx]/[xxx]
	@GetMapping(path = "/path-variable/{name}/{age}")
	public String queryParam2(@PathVariable(name="name") String name,
			@PathVariable(name = "age")int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "name : " + name + ","+"age: " + age;
	}
	
	// 문제1. 새로운 주소 만들어서 요청 응답(인자값 하나)
	//http://localhost:9090/api/get/path-variableEx/[xxx]
	@GetMapping(path = "/path-variableEx/{name}")
	public String queryParamEx(@PathVariable(name = "name")String name) {
		System.out.println("브라우저에서 들어온 값을 받음 연습 : " + name);
		return "[["+name+"]]";
	}
	// 문제2. 새로운 주소 만들어서 요청 응답(인자값 두개)
	//http://localhost:9090/api/get/path-variableEx/[xxx]/[xxx]
	@GetMapping(path = "/path-variableEx2/{name}/{number}")
	public String queryParamEx2(@PathVariable(name = "name")String name,
			@PathVariable(name = "number")int number) {
		System.out.println("name : "+ name);
		System.out.println("number : " + number);
		return "name : " + name + ","+"number : "+number;
	}
	
}
