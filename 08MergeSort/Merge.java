import java.util.*; 
import java.io.*; 

public class Merge{

////////////////////////////////////////////////////////////////////////   

	public static void mergesort(int[] ary){
	if(ary.length < 2){
	return;
	}
		int[] left = new int[ary.length/2];
		int[] right = new int[ary.length - ary.length/2]; //this is clever; John Lin showed me this
		
		
		for(int i = 0; i < ary.length/2; i++){
			left[i] = ary[i];
		}
		for(int i = ary.length/2; i < ary.length; i++){
			right[i - ary.length/2] = ary[i];
		}
		mergesort(left);
		mergesort(right);
		merge(left,right,ary);

	}


////////////////////////////////////////////////////////////////////////   

	public static void merge(int[] a, int[] b, int[] arry){
		int _a = a.length;
		int _b = b.length;
		int aIndex = 0, bIndex = 0, count = 0;
			while(aIndex < _a && bIndex < _b){
				if(a[aIndex] <= b[bIndex]){
					arry[count]= a[aIndex];
					aIndex++;
					count++;
				}else{
					arry[count]= b[bIndex];
					bIndex++;
					count++;
				}
			}
			
			//we're at the end of one of them, so dump the rest in!
			while(aIndex < _a){
					arry[count] = a[aIndex];
					aIndex++;
					count++;
			}
			while(bIndex < _b){
					arry[count] = b[bIndex];
					bIndex++;
					count++;
			}

		}

////////////////////////////////////////////////////////////////////////   


//written for my own convenience
    public static String printArray(int[]data){
	if (data.length == 0){
	    return "{}";
	}
	String ans = "{";
	for(int i = 0; i < data.length; i++){
	    if(i == data.length - 1){
		ans += data[i] + "}";
	    } else{
		ans += data[i] + ", ";
	    }
	}
	return ans;
    }
    
    //////////////////////////////////////////////////////////////////////
    
///five things that you are testing

//randomized min value to max value
//randomized 0-10
//all same value
//sorted
//reverse sorted

public static void main(String[] args){
int[] a = {2,3,4,5,122,13314,2,33,5,4,2};
int[] b = {1,2,3,4,5,6,7,8,9};
int[] c = {10,9,8,7,6,5,4,3};
int[] d = {2,2,2,2,2,2,2,2};
int[] e = {};


System.out.println(printArray(a));
mergesort(a);
System.out.println(printArray(a));

System.out.println(printArray(b));
mergesort(b);
System.out.println(printArray(b));

System.out.println(printArray(c));
mergesort(c);
System.out.println(printArray(c));

System.out.println(printArray(d));
mergesort(d);
System.out.println(printArray(d));

System.out.println(printArray(e));
mergesort(e);
System.out.println(printArray(e));

}}
