package fracCalc;

import java.util.Scanner;

public class FracCalc {
//this is the client code
    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	//parts("2");
    	//names(parts("3_1/2"));
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.println("What is the equation you'd like me to compute?");
    	Scanner userInput = new Scanner(System.in);
    	String input = userInput.nextLine(); //gets equation
    	while (!input.equals("quit")) {
			System.out.println(produceAnswer(input));  //puts into method
			System.out.println("Do you want to keep going? Type \"quit\" to end.");
			input = userInput.nextLine();
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] equat = input.split(" ");
    	String operator = equat[1];
    	Fraction operand1 = new Fraction(equat[0]);
    	Fraction operand2 = new Fraction(equat[2]);
    	String answer = Fraction.doMath(operand1, operator, operand2);
    	
        return answer;
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
