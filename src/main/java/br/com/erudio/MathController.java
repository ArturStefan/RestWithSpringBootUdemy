package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationsException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne)  || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		
		return sub;
	}
	
	@RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationsException("Please set a numeric value!");
		}
		
		Double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);
		
		return mult;
	}
	
	private Double convertToDouble(String strNumber){
		if(strNumber == null) return 0D;
		String number = strNumber.replace(",", ".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;

	}

	public boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
