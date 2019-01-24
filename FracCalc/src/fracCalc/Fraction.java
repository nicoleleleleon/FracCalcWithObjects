package fracCalc;
import java.util.*;

public class Fraction {
	private int whole;
	private int numer;
	private int denom;
// TODO: Fill in the space below with any helper methods that you think you will need
public Fraction() {
	whole = 0;
	numer = 0;
	denom = 1;
	
	}
public Fraction(String operand){
	String[] operandArray = operand.split("_|\\/");//split by _ and /
	//setting values for whole, numer, denom
	   if(operandArray.length==2) {
		  whole = 0;
		  numer = Integer.parseInt(operandArray[0]);
		  denom = Integer.parseInt(operandArray[1]);
	   }else if (operandArray.length==1) {
		   whole = Integer.parseInt(operandArray[0]);
		   numer = 0;
		   denom = 1;
	   }else if (operandArray.length==3) {
		   whole = Integer.parseInt(operandArray[0]);
		   numer = Integer.parseInt(operandArray[1]);
		   denom = Integer.parseInt(operandArray[2]);
		   }
	   int[] improperFrac = {whole, numer, denom};
	   }
public void toString(Fraction op) {//turns op1 or op2 into a String
	String operand = "" + op; 
}
public int[] toImproper(int[] number) {//take in int[] return numerator and denominator in array
	   if (number[0]<0 && number[1]>0) {//so that if it is a negative whole number, it stays negative when it goes to improper
		  number[1] = number[1]*-1;
	   }
	   int numerator = ((number[0]*number[2])+number[1]);
	   int denominator = number[2];
	   int[] frac = {numerator, denominator};
	   return frac;
}

public static boolean isDivisibleBy(int numer, int denom) {
		if(denom==0) {
			throw new IllegalArgumentException("Impossible to divide by \"0\".");
		}
		if(denom==0) {
			return false;
		}else {
		return (numer/denom) - (numer % denom) == (numer/denom);
	}
}
public static int absValue(int value) {
	if(value<=0) {
		return value*(-1);
	}else{
		return value; 
	}
}
public static int gcf(int num1, int num2) { //finds gcf, two int to int
		int newNum1 = absValue(num1);
		int newNum2 = absValue(num2);
	int answer= 1; //if they don't share any factors then gcf is one
	if(newNum1>newNum2) {
		//answer =1;
			for(int i=num2;num2>=1;i--) {
				//working backwards starting from bigger number to get largest number
				if(isDivisibleBy(newNum1,i)&&isDivisibleBy(newNum2,i)) {
					//so that divisible for both numbers
					return i; //so that it stops instead of continuously looping
					}
			} 
	}else if(newNum1<newNum2){
					// since don't want to divide smaller# by bigger#
						for(int i=newNum1;newNum1>=1;i--) {
							if((isDivisibleBy(num1,i))&&(isDivisibleBy(num2,i))) {
								return i;		
					}		
				}
}
	if(num1<0 || num2<0) {
		answer *= -1;
	}
return answer;
}


}
