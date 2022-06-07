package com.example.jsptest.dto;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class User {

	
	
	@NotEmpty
	@Size(min = 1, max=10)
	private String name;
	
	@Min(1)
	@NonNull
	private Integer age;
	
}
