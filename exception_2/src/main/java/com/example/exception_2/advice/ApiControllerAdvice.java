package com.example.exception_2.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.exception_2.dto.CustomError;

@RestControllerAdvice
public class ApiControllerAdvice {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		System.out.println("예외 발생");
		System.out.println("================");
		System.out.println(e.getClass());
		System.out.println("================");
		System.out.println(e.getMessage());
		System.out.println("================");
		System.out.println(e.getCause());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
	}

	// Get방식일때 넘어오는 파라미터가 없을 경우 발생
//	@ExceptionHandler(value = MissingServletRequestParameterException.class) 예외 발생시켜보기
	@ExceptionHandler(value = MissingServletRequestParameterException.class)
	public ResponseEntity<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
		System.out.println("========");
		System.out.println("MissingServletRequestParameterException 동작!!!");

		String fieldName = e.getParameterName();
		String fieldType = e.getParameterType();
		String invalidValue = e.getMessage();

		System.out.println("fieldName: " + fieldName);
		System.out.println("fieldType: " + fieldType);
		System.out.println("invalidValue: " + invalidValue);
		// 파라미터가 없을 때 요청을 잘못했기 때문에 Bad_request
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldName + "");

	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("methodArgumentNotValidExceptrion 예외발생");
		// 한번에 전부 들어 온다.
		// 리스트 필요
		List<CustomError> errorList = new ArrayList<>();
		BindingResult bindingResult = e.getBindingResult();
		bindingResult.getAllErrors().forEach(action -> {
			// action
			FieldError field = (FieldError) action;

			String fieldName = field.getField();
			String message = field.getDefaultMessage();
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
			System.out.println("action : " + action.toString());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}

	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException e) {
		// 동시에 확인 (validation)
		System.out.println("constraintViolationException 예외 발생");
		List<CustomError> errorList = new ArrayList<CustomError>();
		e.getConstraintViolations().forEach(error -> {
			String strField = error.getPropertyPath().toString();
			int index = strField.indexOf(".");
			String fieldName = strField.substring(index + 1);
			String message = error.getMessage();
			CustomError customError = new CustomError();
			customError.setField(fieldName);
			customError.setMessage(message);
			errorList.add(customError);
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	}
}
