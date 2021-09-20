package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationsException;
import br.com.erudio.math.MathOperations;
import br.com.erudio.validations.OperationsValidation;

@RestController
public class MathController {
	OperationsValidation validations = new OperationsValidation();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!validations.areNumerical(numberOne, numberTwo)) {
			throw new UnsupportedMathOperationsException(validations.getMessage());
		}
		
		return MathOperations.sum(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!validations.areNumerical(numberOne, numberTwo)) {
			throw new UnsupportedMathOperationsException(validations.getMessage());
		}
		
		return MathOperations.subtraction(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!validations.areNumerical(numberOne, numberTwo)) {
			throw new UnsupportedMathOperationsException(validations.getMessage());
		}
				
		return MathOperations.multiplication(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!validations.divisionValidation(numberOne, numberTwo)) {
			throw new UnsupportedMathOperationsException(validations.getMessage());
		}
		
		return MathOperations.division(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/average/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!validations.areNumerical(numberOne, numberTwo)) {
			throw new UnsupportedMathOperationsException(validations.getMessage());
		}
		
		return MathOperations.average(numberOne, numberTwo);
	}
	
	@RequestMapping(value="/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number) throws Exception {
		if(!validations.areNumerical(number)) {
			throw new UnsupportedMathOperationsException(validations.getMessage());
		}
		
		return MathOperations.squareRoot(number);
	}
	
}
