package br.com.erudio.validations;

import br.com.erudio.converters.Converters;

public class OperationsValidation {

	private boolean areNumerical;
	private boolean divisionByZero;
	private boolean divisionValidation;
	private String message;
	
	public OperationsValidation() {
		this.areNumerical = true;
		this.divisionByZero = false;
		this.divisionValidation = false;
		this.message = "";
	}
	
	public boolean getAreNumerical() {
		return areNumerical;
	}

	public void setAreNumerical(boolean areNumerical) {
		this.areNumerical = areNumerical;
	}

	public boolean getDivisionByZero() {
		return divisionByZero;
	}

	public void setDivisionByZero(boolean divisionByZero) {
		this.divisionByZero = divisionByZero;
	}
	
	public boolean getDivisionValidation() {
		return divisionValidation;
	}

	public void setDivisionValidation(boolean divisionValidation) {
		this.divisionValidation = divisionValidation;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public boolean areNumerical(String numberOne, String numberTwo) {
		
		if(!Converters.isNumeric(numberOne) || !Converters.isNumeric(numberTwo)){
			setAreNumerical(false);
			setMessage("Please set a numeric value!");
		}
		else {
			setAreNumerical(true);
			setMessage("");
		}
		
		return getAreNumerical();
	}
	
	public boolean areNumerical(String number) {
		
		if(!Converters.isNumeric(number)){
			setAreNumerical(false);
			setMessage("Please set a numeric value!");
		}
		else{
			setAreNumerical(true);
			setMessage("");	
		}
		
		return getAreNumerical();
	}
	
	public boolean divisionByZero(String numberTwo) {
		
		if(Converters.convertToDouble(numberTwo) == 0.0) {
			setDivisionByZero(true);
			setMessage("It is not possible to divide by 0!");
		}
		else{
			setDivisionByZero(false);
			setMessage("");
		}
		
		return getDivisionByZero();
		
	}
	
	public boolean divisionValidation(String numberOne, String numberTwo) {
		areNumerical(numberOne, numberTwo);
		divisionByZero(numberTwo);
		
		if(!getDivisionByZero() && getAreNumerical()) {
			setDivisionValidation(true);
		}
		else if(!getAreNumerical()){
			setMessage("Please set a numeric value!");
			setDivisionValidation(false);
		}
		else{
			setMessage("It is not possible to divide by 0!");
			setDivisionValidation(false);
		}
		
		return getDivisionValidation();
		
	}

}
