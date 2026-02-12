package com.capgemini.mockito;

public class Calculator {
	private MathService mathService;
	
	public Calculator(MathService mathService) {
		this.mathService=mathService;
	}
	public int sum(int a,int b) {
		return mathService.sum(a, b);
	}
}
 
