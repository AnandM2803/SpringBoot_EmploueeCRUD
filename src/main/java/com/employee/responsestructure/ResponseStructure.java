package com.employee.responsestructure;

import lombok.Data;

@Data
public class ResponseStructure<T> {

	
	int code;
	String messga;
	T dataT;
}
