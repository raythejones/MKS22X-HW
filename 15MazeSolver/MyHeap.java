import java.util.*;

public class MyHeap {

private Location[] data = new Location[20];
private int size;
private boolean min;

/*
 Constructors
 -MyHeap() - construct empty max heap
 -MyHeap(boolean) - true: construct empty max heap, false: construct empty min heap.
 Methods
 -void add(String s)
 -String remove()
 -String peek()

Private methods:
 -pushUp()
 -pushDown()
*/


/////////////////////////////////////////////////////////// Constructors

public MyHeap(){
size = 0;
min = false;
}


public MyHeap(boolean type){
	if(type){
	//create a max heap
size = 0;
	min = false;
	}
	else{
	//create a min heap 
size = 0;
min = true;
	}	


}

public int size(){
return size;
}

public int getSize(){
return size;
}


///////////////////////////////////////////////////////////  add

    public void add(Location s){
	if(size == data.length){
	    Location[] temp = new Location[data.length * 2];
	    for(int position = 0; position < data.length; position++){
		temp[position] = data[position];
	    }
	    data = temp;
	}
	data[size] = s;
		pushUp();

	size++;
    }

/////////////////////////////////////////////////////////// remove
 
 public Location remove(){
 	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    Location ans = data[1];
	    data[1] = data[size];
	    size--;
	    pushDown();
	    return ans;
	}
 }
 
 /////////////////////////////////////////////////////////// peek

public Location peek(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[1];
	}
}
 /////////////////////////////////////////////////////////// pushUp and pushDown

    private void pushUp(){
	int position = size;
	while(position > 1 && min){
	    Location temp = data[position];
	    data[position] = data[position/2];
	    data[position/2] = temp;
	}
    }

    private void pushDown(){
	int position = 1;
	while(position < size && !min){
	    Location temp = data[position];
	    data[position] = data[position*2];
	    data[position*2] = temp;
	}
    }

 /////////////////////////////////////////////////////////// toString


    public String toString(){
	String toReturn = "[";
        for(int position = 0; position <= size; position++){
	    toReturn += data[position] + ", ";
	}
	toReturn = toReturn.substring(0, toReturn.length() - 2) + "]";
	return toReturn;
    }


    public static void main(String[]args){
    }

}