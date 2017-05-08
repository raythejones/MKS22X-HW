import java.util.*;

public class StackCalc{

public static double eval(String s){
    String[] tokens = s.split(" ");
    Stack<Double> values = new Stack<Double>();
    
    for(String token : tokens){
      if(isOp(token)){
       	 values.push(perform(token,values.pop(),values.pop()));
      }
      else{
        values.push(Double.parseDouble(token));
      }
    }
    
    return values.pop();
}

    public static boolean isOp(String a){
	return a.equals("+") || a.equals("-") || a.equals("/") || a.equals("*");
    }

    public static double perform(String op, double a, double b){
	if (op.equals("+")){
	    return a + b;
	}
	else if (op.equals("*")){
	    return a * b;
	}
	else if (op.equals("-")){
	    return b - a;
	}
	else{
	    return b / a;
	}
    }

    public static void main(String[] args){
        System.out.println(StackCalc.eval("10 2 +"));//12.0
        System.out.println(StackCalc.eval("10 2 -"));//8.0
        System.out.println(StackCalc.eval("10 2.0 +"));//12.0
        System.out.println(StackCalc.eval("11 3 - 4 + 2.5 *"));//30.0
    	System.out.println(StackCalc.eval("8 2 + 99 9 - * 2 + 9 -"));//893.0
   	 System.out.println(StackCalc.eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
    }

 

}