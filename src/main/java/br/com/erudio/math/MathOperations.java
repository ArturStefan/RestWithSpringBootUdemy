package br.com.erudio.math;

import br.com.erudio.converters.Converters;

public class MathOperations {
	public static Double sum(String numberOne, String numberTwo) {
		
		Double sum = Converters.convertToDouble(numberOne) + Converters.convertToDouble(numberTwo);
		
		return sum;
	}
	
	public static Double subtraction(String numberOne, String numberTwo) {
		
		Double subtraction = Converters.convertToDouble(numberOne) - Converters.convertToDouble(numberTwo);
		
		return subtraction;
	}
	
	public static Double multiplication(String numberOne, String numberTwo) {
		
		Double multiplication = Converters.convertToDouble(numberOne) * Converters.convertToDouble(numberTwo);
		
		return multiplication;
	}
	
	public static Double division(String numberOne, String numberTwo) {
		
		Double division = Converters.convertToDouble(numberOne) / Converters.convertToDouble(numberTwo);		
		
		return division;
	}
	
	public static Double average(String numberOne, String numberTwo) {
		
		Double average = (Converters.convertToDouble(numberOne) + Converters.convertToDouble(numberTwo)) / 2;		
		
		return average;
	}
	
	public static Double squareRoot(String number) {
		
		Double squareRoot = Math.sqrt((Converters.convertToDouble(number)));
		
		return squareRoot;
	}
}
