package com.calculator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.calculator.demo.Calculator;

public class CalculatorTest {
	//Calculator calculator = new Calculator();
	
	private Calculator calculator;
	@BeforeEach
	void setup() {
		calculator = new Calculator();
	}
	@Test
	@DisplayName("Test sum of two positive numbers")
	void testSumOfTwoPositiveNUmbers() {
		assertEquals(5, calculator.sum(2,3),"Sum of 2 and 3");
	}
	@RepeatedTest(3)
	@DisplayName("Test sum with repeated execution")
	void testSumRepeated() {
		assertEquals(-5, calculator.sum(-2,-3),"Sum of -2 and -3");
	}
	public void testTwoAndTwoGivesFour() {
		assertEquals(4, calculator.add(2,2));
	}
	@Test 
	public void testFiveAndFourGivesNine() {
		assertEquals(9, calculator.add(5, 4));
	}
	@Test
	public void testFiveAndFour() {
		assertEquals(1,calculator.sub(5,4));
	}
	
	//Nested Test
	@Nested
	@DisplayName("Subtraction Tests")
	class SubtractionTests{
		@Test
		@DisplayName("Test of subtraction of two numbers")
		void testSubtraction() {
			assertEquals(1,calculator.sub(5,4 ),"5-4 will be 1");
		}
		@Test
		@DisplayName("Test of addition of two numbers")
		void testAddition() {
			assertEquals(9,calculator.add(5,4 ),"5+4 will be 9");
		}
	}
	
	//Parameterized Test
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4,5})
	@DisplayName("Test multiplication by 2")
	void testMultiplyByTwo(int number) {
		assertEquals(number * 2, calculator.multiply(number, 2), "Multiplication");
	}
	
	@ParameterizedTest
    @CsvSource({"2,2,4","2,3,6","4,4,16"})
    void testMultiply(int x,int y,int expected) {
    	assertEquals(expected,calculator.multiply(x,y));
    }
	
	@ParameterizedTest
    @CsvFileSource(resources = "/calculator-data.csv",numLinesToSkip= 1)
    @DisplayName("Test sum using CSV file")
    void testSumUsingCsvFile(int a,int b,int expectedSum) {
    	assertEquals(expectedSum, calculator.add(a, b));
    }
	
}