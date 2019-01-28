package fracCalc;
import java.util.*;

public class Fraction {
	private int whole;
	private int numer;
	private int denom;
	private int[] improperFrac = {0,1};
// TODO: Fill in the space below with any helper methods that you think you will need
public Fraction() {//auto-int
	whole = 0;
	numer = 0;
	denom = 1;
	}
public Fraction(String operand){//sets vals of whole, numer, denom and makes improperFrac
	
	if(operand.indexOf("_")>0 && operand.indexOf("/")>0) {
		
		String[] operandArray = operand.split("_|\\/"); //splits _ and / ,, "|" makes it not split "_/" ,, "\\" separates them?
		 whole = Integer.parseInt(operandArray[0]);
		   numer = Integer.parseInt(operandArray[1]);
		   denom = Integer.parseInt(operandArray[2]);
		   
	}else if (operand.indexOf("_")<0 && operand.indexOf("/")>0) {
		
		String[] operandArray = operand.split("/");
		 whole = 0;
		 numer = Integer.parseInt(operandArray[0]);
		 denom = Integer.parseInt(operandArray[1]);
		
	}else if (operand.indexOf("_")<0 && operand.indexOf("/")<0){
		
		String[] operandArray = {operand};
		 whole = Integer.parseInt(operandArray[0]);
		 numer = 0;
		 denom = 1;
	}
	   	if (whole<0 && numer>0) {//so that if it is a negative whole number, it stays negative when it goes to improper
			   numer = numer*-1;
		   }
		   int numerator = ((whole*denom)+numer);
		   int denominator = denom;
		   improperFrac[0] = numerator;
		   improperFrac[1] = denominator;
	   }
public void toString(Fraction op) {//turns op1 or op2 into a String
	String operand = "" + op; 
}
public int[] toImproper(int[] number) {//take in int[]improperFrac return numerator and denominator in array
	   if (number[0]<0 && number[1]>0) {//so that if it is a negative whole number, it stays negative when it goes to improper
		   number[1] = number[1]*-1;
	   }
	   int numerator = ((number[0]*number[2])+number[1]);
	   int denominator = number[2];
	   int[] newFrac = {numerator, denominator};
	   return newFrac;
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
public static String multiply(Fraction num1,Fraction num2) {//if there was a * will go to this
   	int newNumer = (num1.improperFrac[0])*(num2.improperFrac[0]);//takes array of numer and denom and multiplies
    int newDenom = (num1.improperFrac[1])*(num2.improperFrac[1]);
   return newNumer + "/" + newDenom;
}
public static String division(Fraction num1,Fraction num2) {//takes array of numer and denom and divides
	   //System.out.println(((toImproper(num1))[0]) + "and" + ((toImproper(num2))[1]));
	   int numer = (num1.improperFrac[0])*(num2.improperFrac[1]);
	   int denom = (num1.improperFrac[1])*(num2.improperFrac[0]);
	   if(denom<0) {
		   denom *= -1;
		   numer *= -1;
	   }
	   //System.out.println(numer + "/" + denom);
	   return numer + "/" + denom;
}
public static int[] toSameDenom(int[] num1, int[] num2) {
	   int[] newNum = {num1[0]*num2[1],num1[1]*num2[1]};
	   return newNum;
	   
}
public static String addition(Fraction num1,Fraction num2) {//adds
	 int numerator = toSameDenom(num1.improperFrac,num2.improperFrac)[0] + toSameDenom(num2.improperFrac,num1.improperFrac)[0]; //adds numerators of the fractions that now have the same denom
	 int denom = toSameDenom(num1.improperFrac,num2.improperFrac)[1];//both have same denom anyways
	 //System.out.println(numerator + "/" + denom);
	 return numerator + "/" + denom;
}
public static String subtraction(Fraction num1, Fraction num2) {//subtracts
	   int numerator = toSameDenom(num1.improperFrac,num2.improperFrac)[0] - toSameDenom(num2.improperFrac,num1.improperFrac)[0];
	   int denom = toSameDenom(num1.improperFrac,num2.improperFrac)[1];//both have same denom anyways
	   return numerator + "/" + denom;
}
	public static String toMixedNum(int[] intFrac) { //improper fraction to mixed number-- 2 ints to string
		int whole = intFrac[0] / intFrac[1];
		int numer = intFrac[0] % intFrac[1];
		int denom = absValue(intFrac[1]);
		if(numer<0 && whole<0) {
			numer *= -1;
		}
		String answer = Integer.toString(whole) + "_" + Integer.toString(numer) + "/" + Integer.toString(denom);
		//System.out.println(answer);
		if(answer.startsWith("0_0")) {
			answer = "0";
		} else if (answer.startsWith("0_")) {
			answer = answer.replace("0_", "");
		} else if (answer.indexOf("_0")!=-1) {
			answer = Integer.toString((intFrac[0] / intFrac[1]));
		}
		return answer;
	}
public static String toReduced(String answer) {
	   String[] improperFrac = answer.split("/");
	   int[] intFrac = new int[2];
	   for(int i=0;i<improperFrac.length;i++) {
		   intFrac[i]=Integer.parseInt(improperFrac[i]); // find way to reduce if 3_0/1 , 0_0/0, etc.
	   }
	   int gcf = absValue(gcf(intFrac[0], intFrac[1]));
	   //System.out.println("gcf " + gcf);
	   if(gcf!=0) {
	   intFrac[0] = intFrac[0]/gcf;
	   intFrac[1] = intFrac[1]/gcf;
	   } 
	   return toMixedNum(intFrac);
}
public static String doMath( Fraction op1,String operator, Fraction op2) {
	 String answer = "";
     if(operator.equals("+")) {
   	  answer = addition(op1,op2);
     } else if (operator.equals("-")) {
   	  answer = subtraction(op1,op2);
     } else  if (operator.equals("*")) {
   	  answer = multiply(op1,op2);
     } else if (operator.equals("/")){
   	  answer = division(op1,op2);
     }else {
   	  answer = "Not a valid operator";
     }
     return toReduced(answer);
}
}