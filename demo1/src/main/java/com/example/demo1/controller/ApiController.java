package com.example.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller��.. �ּҸ� ������ִ� ����
// �ּ�ü�踦 ����� ����.
@RestController
@RequestMapping("/api/get")
public class ApiController {

	// URL : �ڿ� ��û�ϴ� �ּ� ü����
	// URI : �ĺ��� ���
	// http://localhost:9090/api/hello
	// http://localhost:9090/api/get/hello
	@GetMapping("/hello")
	public String getHello() {
		return "sayhello";
	}
	// path-variable���
	// get -> URI��� ���(�����͸� ��Ƽ� ��û) // ó���� �ϰ� ������ ���ټ� �ִ�.
	//http://localhost:9090/api/get/path-variable/[xxx]
	@GetMapping(path="/path-variable/{name}")
	public String queryParam(@PathVariable(name = "name") String name) {
		System.out.println("���������� ���� ���� ���� : "+name);
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
	
	// ����1. ���ο� �ּ� ���� ��û ����(���ڰ� �ϳ�)
	//http://localhost:9090/api/get/path-variableEx/[xxx]
	@GetMapping(path = "/path-variableEx/{name}")
	public String queryParamEx(@PathVariable(name = "name")String name) {
		System.out.println("���������� ���� ���� ���� ���� : " + name);
		return "[["+name+"]]";
	}
	// ����2. ���ο� �ּ� ���� ��û ����(���ڰ� �ΰ�)
	//http://localhost:9090/api/get/path-variableEx/[xxx]/[xxx]
	@GetMapping(path = "/path-variableEx2/{name}/{number}")
	public String queryParamEx2(@PathVariable(name = "name")String name,
			@PathVariable(name = "number")int number) {
		System.out.println("name : "+ name);
		System.out.println("number : " + number);
		return "name : " + name + ","+"number : "+number;
	}
	
}
