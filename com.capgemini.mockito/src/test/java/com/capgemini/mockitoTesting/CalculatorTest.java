package com.capgemini.mockitoTesting;

import org.junit.jupiter.api.Test;

import MocktioTesting.Calculator;
import MocktioTesting.ExtendWith;
import MocktioTesting.InjectMocks;
import MocktioTesting.MathService;
import MocktioTesting.Mock;
import MocktioTesting.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

	@Mock
	MathService mathService;
	@InjectMocks
	Calculator c;
	
	@Test
	void testAdd() {
		when(mathService.sum)
	}
	
}