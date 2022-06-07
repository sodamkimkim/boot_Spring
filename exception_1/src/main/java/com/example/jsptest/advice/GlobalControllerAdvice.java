package com.example.jsptest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(basePackages = "com.example.jsptest.controller") 특정 패키지에서만 동작
// @ControllerAdvice // 뷰리졸뷰, data(MessageConverter)
@RestControllerAdvice // Global
public class GlobalControllerAdvice {
	// 모든 예외상황을 처리하고 싶을 때 사용
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("======================");
		System.out.println(e.getClass());
		System.out.println(e.getMessage());
		System.out.println("======================");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	// 특정 예외상황에서는 다른 응답처리를 하고 싶을 때
	// MissngServletRequestParameterException
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println("MissingServletRequestParameterException 동작!!!");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

	}

}
