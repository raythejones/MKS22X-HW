public class Recursion{

    public static String name(){

	return "Jones,AugustRay";
    }
    
    public static double sqrt(double n){
	double result = 0;
	if(n < 0){
	    throw new IllegalArgumentException();
	}

	if(n == 0){
	    return 0.0;
	}
	result = makeGuess(n, 1);
	return result;
	
    }
    ;
    public static double makeGuess(double n, double original_guess) {
	double originalN = n;
	double better_guess = 0;

	
	better_guess = ((n / original_guess) + original_guess) / 2.0;


	if((((better_guess * better_guess) - originalN) / originalN) * 100 <= .000000000001 ){
	return better_guess;
	}

	else{
	return makeGuess(n, better_guess);
	}
	}
    
    
    public static void main(String[]args){

    }

}
