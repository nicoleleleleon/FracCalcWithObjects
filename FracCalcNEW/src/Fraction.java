import java.util.*;
public class Fraction {

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
   //    String array = Arrays.toString(input.split(" "));
   //    System.out.println(array);
       String[] equat = input.split(" ");
       String operand1 = equat[0];
       String operator = equat[1];
       String operand2 = equat[2];
//       int num1 = Integer.parseInt(operand1);
 //      int num2 = Integer.parseInt(operand2);
      int[] num1 = intArray(array(parts(operand1)));
      int[] num2 = intArray(array(parts(operand2)));
      //if */+-...  do method
      //multiply(num1,num2);
       // return names(array(parts(operand2)));
      String answer = "";
      if(operator.equals("+")) {
    	  answer = addition(num1,num2);
      } else if (operator.equals("-")) {
    	  answer = subtraction(num1,num2);
      } else  if (operator.equals("*")) {
    	  answer = multiply(num1,num2);
      } else if (operator.equals("/")){
    	  answer = division(num1,num2);
      }else {
    	  answer = "Not a valid operator";
      }
      return toReduced(answer);
    }
	    
   public static String[] parts(String input) {//split into array without "/" and "_"
    	if(input.indexOf("_")>0 && input.indexOf("/")>0) {
    		String[] splitChars = input.split("_|\\/"); //splits _ and / ,, "|" makes it not split "_/" ,, "\\" separates them?
   		//System.out.println(Arrays.toString(splitChars));
    	return splitChars;
    	}else if (input.indexOf("_")<0 && input.indexOf("/")>0) {
    		String[] splitUnder = input.split("/");
    	//	System.out.println(Arrays.toString(splitUnder));
    		return splitUnder;
    	}else if (input.indexOf("_")<0 && input.indexOf("/")<0){
    		String[] noSplit = {input};
    	//	System.out.println(Arrays.toString(noSplit));
    		return noSplit;
    	}else {
    	String[] test = {"I","can't","code"};
    	return test;
   }
    // TODO: Fill in the space below with any helper methods that you think you will need
}
   public static String[] array(String[] parts) {//turn array into format whole, num, denom
	  String[] array = new String[3];
	   if(parts.length==2) {
		  array[0] = "0";
		  array[1]=parts[0];
		  array[2] = parts[1];
	   }else if (parts.length==1) {
		   array[0] = parts[0];
		   array[1] = "0";
		   array[2] = "1";
	   }else if (parts.length==3) {
		   for(int i=0; i<parts.length; i++) {
			   array[i]=parts[i];
		   }
	   }
	   return array;
   }
		      
   public static String names(String[] array) {//print out labels of the wholes, nums, denoms
	   String name = "whole:" + array[0] + " numerator:" + array[1] + " denominator:" + array[2];
	   return name;
   }
   public static int[] intArray(String[] array) {//turn String array into int array
	   int[] intArray = new int[3];
	   for(int i=0;i<array.length;i++) {
		   intArray[i]=Integer.parseInt(array[i]);
	   }
	   return intArray;
   }
 //determines if int is evenly divisible by another//returns boolean
 	public static boolean isDivisibleBy(int num, int deno) {
 		if(deno==0) {
 			throw new IllegalArgumentException("Impossible to divide by \"0\".");
 		}
 		if(deno==0) {
 			return false;
 		}else {
 		return (num/deno) - (num % deno) == (num/deno);
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
				
   public static String multiply(int[] num1, int[] num2) {//if there was a * will go to this
	   	int newNumer = ((toImproper(num1))[0])*((toImproper(num2))[0]);//takes array of numer and denom and multiplies
	    int newDenom = ((toImproper(num1))[1])*((toImproper(num2))[1]);
	   return newNumer + "/" + newDenom;
}
   public static int[] toImproper(int[] number) {//take in int[] return numerator and denominator in array
	   if (number[0]<0 && number[1]>0) {//so that if it is a negative whole number, it stays negative when it goes to improper
		  number[1] = number[1]*-1;
	   }
	   int numerator = ((number[0]*number[2])+number[1]);
	   int denominator = number[2];
	   int[] frac = {numerator, denominator};
	   return frac;
}
   public static String division(int[] num1,int[] num2) {//takes array of numer and denom and divides
	   //System.out.println(((toImproper(num1))[0]) + "and" + ((toImproper(num2))[1]));
	   int numer = ((toImproper(num1))[0])*((toImproper(num2))[1]);
	   int denom = ((toImproper(num1))[1])*((toImproper(num2))[0]);
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
   public static String addition(int[] num1,int[] num2) {//adds
	 int numerator = toSameDenom(toImproper(num1),toImproper(num2))[0] + toSameDenom(toImproper(num2),toImproper(num1))[0]; //adds numerators of the fractions that now have the same denom
	 int denom = toSameDenom(toImproper(num1),toImproper(num2))[1];//both have same denom anyways
	 //System.out.println(numerator + "/" + denom);
	 return numerator + "/" + denom;
}
   public static String subtraction(int[] num1, int[] num2) {//subtracts
	   int numerator = toSameDenom(toImproper(num1),toImproper(num2))[0] - toSameDenom(toImproper(num2),toImproper(num1))[0];
	   int denom = toSameDenom(toImproper(num1),toImproper(num2))[1];//both have same denom anyways
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
   }//somehow broke my code more? keeps making 0s, probably a mistake in gcf, toReduced, or toMixedNum
   //when time, go to toMixedNum and change the if statement for answer 0 to see if makes difference
}

