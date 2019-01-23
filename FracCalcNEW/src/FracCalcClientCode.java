import java.util.Scanner;

public class FracCalcClientCode {
	public static void main(String[] args){
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
}
