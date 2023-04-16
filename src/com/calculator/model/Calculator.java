package com.calculator.model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator implements java.io.Serializable {
	
	private double operandOne;
	private double operandTwo;
	private String Operation;
	
	public Calculator() {
		
	}

	public String getOperation() {
		return Operation;
	}

	public void setOperation(String Operation) {
		this.Operation = Operation;
	}

	public double getOperandOne() {
		return operandOne;
	}

	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}

	public double getOperandTwo() {
		return operandTwo;
	}

	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	
	public void performOperation() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("------Calculator (Add or Subtract two numbers)-----");
	    System.out.println("\nFirst number:");

	    double num1 = 0.0;
	    try {
	        num1 = scanner.nextDouble();
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input! Please enter a valid number.");
	        scanner.nextLine(); // clear the scanner buffer
	        performOperation(); // call performOperation() recursively to retry
	        return; // exit the method
	    }
	    this.setOperandOne(num1);

	    System.out.println("\nOperator( + / - ):");
	    String operator = scanner.next();
	    this.setOperation(operator);

	    System.out.println("\nSecond number:");
	    double num2 = 0.0;
	    try {
	        num2 = scanner.nextDouble();
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input! Please enter a valid number.");
	        scanner.nextLine(); // clear the scanner buffer
	        performOperation(); // call performOperation() recursively to retry
	        return; // exit the method
	    }
	    this.setOperandTwo(num2);

	    this.getResult();
	}

	
	private void getResult() {
		double result;
		String operator = this.getOperation();
		
		if(operator.equals("+")) {
			result = this.getOperandOne() + this.getOperandTwo();
			System.out.println("\nResult is: " + result);
			this.restart();
			
		}else if(operator.equals("-")) {
			result = this.getOperandOne() - this.getOperandTwo();
			System.out.println("\nResult is: " + result);
			this.restart();
		}else {
			System.out.println("\nYou have not put a Valid input. Please Try Again");
			this.performOperation();
			return;
		}
		

	}
	
	private void restart() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\nDo you want to try again? (yes/no)");
        String answer = scanner.next();
        if(answer.equals("yes") || answer.equals("Yes")) {
        	this.performOperation();
        }else if (answer.equals("no") || answer.equals("No")) {
        	System.out.println("Thank you for using my calculator. Good Bye");
        }else {
        	System.out.println("\nPlease put a valid answer");
        	this.restart();
        	return;
        }
    	
	}

}
