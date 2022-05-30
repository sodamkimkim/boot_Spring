package com.example.demo2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.DTO.UserRequest;

/**
 * POST방식에 대한 이해 및 실습<br>
 * 학습목표<br>
 * Json이해<br>
 * post주소 맵핑<br>
 * 
 * @RequestBody에 대한 이해와 Map구조로 값 받아보기<br>
 * @Dto를 사용gotj 처리해보기<br>
 * 
 *       Json String : value<br>
 *       number : value<br>
 *       boolean : value<br>
 *       object : value -->{}<br>
 *       list : value --> []<br>
 * 
 * 
 * @author ITPS
 *
 */
@RestController
@RequestMapping("/api2")
public class PostApiController {

	/**
	 * { "name" : "value",<br>
	 *  "age" : "value" }<br>
	 * 
	 * @param requestData
	 * @return
	 */
	// 1. Map
	// http://localhost:9090/api2/post1 (POST) --> post 방식.. 웹브라우저 주소창으로 보낼 수 없다
	@PostMapping("/post1")
	public String post1(@RequestBody Map<String, Object> requestData) {
		
		System.out.println("post1 test1");
		StringBuffer sb = new StringBuffer();
		
		requestData.entrySet().forEach(entry -> {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
			sb.append(entry.getKey() + "=" + entry.getValue());
		});
		return sb.toString();
	}
	
	// 2. DTO 방식
	// java /  mobile
	// 네트워크 통신 BR, BW --> 문자열 전송(json parsing)
	// why?? 문자열이 자동으로 object가 되는가?
	// 메시지 converter라는 녀석이 자동으로 문자열을 파싱해서 우리가 선언한 userRequest에 mapping해주고 있다. 
	@PostMapping("/post2")
	public String post2(@RequestBody UserRequest requestData) {
		System.out.println(requestData.toString() + " 데이터가 잘 들어옴");
		return requestData.toString(); 
	}
	
}
