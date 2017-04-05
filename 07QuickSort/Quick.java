import java.util.*;

public class Quick{
    public static int[] part(int[] data, int start, int end){
	Random randInt = new Random();
	int x = randInt.nextInt(end-start+1) + start;
	int[] ans = new int[2];
	int s = start;
	int i = start + 1;
	int e = end;
	int v = data[x];
	swap(data, start, x);
	while(i <= e){
	    if(data[i] == v){
		i ++;
	    }
	    else if(data[i] < v){
		swap(data, s, i);
		s++;
		i++;
	    }
	    else{
		swap(data, i, e);
		e--;
	    }
	}
	ans[0] = s;
	ans[1] = e;
	return ans;
    }
 ////////////////////////////////////////////////////////////////////////   
   
    public static void swap(int[] data, int x, int y) {
	int temp = data[x];
	data[x] = data[y];
	data[y] = temp;
    }
    
////////////////////////////////////////////////////////////////////////   
   
    public static int quickselect(int[] data, int k){
    	return quickselectH(data, k, 0, data.length - 1);
    }
 
 ////////////////////////////////////////////////////////////////////////   
   
    public static int quickselectH(int[] data, int k, int start, int end){
    	int[] _data = part(data,start,end);
    	if(k >= _data[0] && k <= _data[1]){
    	    return data[k];
    	}
    	if(_data[1] < k){
    	    return quickselectH(data,k,_data[1]+1,end);
    	}
    	return quickselectH(data,k,start,_data[0]-1);
    }
    
    ////////////////////////////////////////////////////////////////////////   

    public static void quicksort(int[] data){
	quicksortH(data, 0, data.length-1);
    }
   
   ////////////////////////////////////////////////////////////////////////   
 
    public static void quicksortH(int[] data, int start, int end){
	if(start < end){
	    int[] _data = part(data, start, end);
	    quicksortH(data, start, _data[0]-1);
	    quicksortH(data, _data[1]+1, end);
	}
    }
    
 ////////////////////////////////////////////////////////////////////////   

//convenient method for my own purposes   
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
    
 ////////////////////////////////////////////////////////////////////////   

   public static void main(String[]args){
    
    //TESTS
    
    
    
    //reverse order
    	int[] a = {10,9,8,7,6,5,4,3,2,1};
    		//print before
    	System.out.println(printArray(a));

    	quicksort(a);

//print after
System.out.println(printArray(a));

	//all same
    	int[] b = {0,0,0,0,0,0,0,0,0,0};
    		//print before

    	System.out.println(printArray(b));

    	quicksort(b);
//print after
System.out.println(printArray(b));

	//already correct order
    	int[] c = {1,2,3,4,5,6,7,8,9,10};
     		//print before
   	System.out.println(printArray(c));

    	quicksort(c);

//print after
System.out.println(printArray(c));

//empty
    	int[] d = {};
     		//print before
   	System.out.println(printArray(d));

    	quicksort(d);

//print after
System.out.println(printArray(d));

    }
    
		
}
