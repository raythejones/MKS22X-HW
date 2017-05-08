import java.util.NoSuchElementException;

public class MyDeque{
    String[] data = new String[10];
    int front = 5, back = 4;
private int size = 0;


public int size(){
	return size;
}


/////////////////////////////////////////////////////////// isFull and isEmpty


    private boolean isFull(){
	return (back+1) % data.length == front && !isEmpty();
    }

    private boolean isEmpty(){
	return data[front] == null;
    }
    
/////////////////////////////////////////////////////////// addFirst
    
    
    
    public void addFirst(String s){
	if(s == null){
	    throw new NullPointerException();}
	if(isFull()){
	    doubleCapacity();
	}
	
	if(front == 0){
	    front = data.length;
	}

	front--;
	data[front] = s;
	
	size ++;
	
    }
/////////////////////////////////////////////////////////// addLast

    public void addLast(String s){
	if(s == null){
	    throw new NullPointerException();
	}

	if(isFull()){
	    doubleCapacity();
	}
	
	if(back == data.length-1){
	    back = -1;
	}

	back++;
	data[back] = s;
	
	size ++;
    }

/////////////////////////////////////////////////////////// removeFirst

    public String removeFirst(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}

	String old = data[front];
	data[front] = null;
	front++;

	if(front == data.length){
	    front = 0;
	}
	size --;
	return old;
	
	
	
    }

/////////////////////////////////////////////////////////// removeLast

    public String removeLast(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	
	String old = data[back];
	data[back] = null;
        back--;

	if(back == -1){
	    back = data.length-1;
	}
		size --;

	return old;
	
    }

/////////////////////////////////////////////////////////// getFirst and getLast

    public String getFirst(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}
	
	return data[front];
    }

    public String getLast(){
	if(isEmpty()){
	    throw new NoSuchElementException();
	}

	return data[back];
    }

/////////////////////////////////////////////////////////// toString

    public String toString(){
	if(front - back == 1){
	    return "[]";
	}
	
	String s = "[" + data[front];
	for(int i = front+1; i != back+1; i++){
	    if(i == data.length){
		i = 0;
	    }

	    s += ", " + data[i];
	}

	return s + "]";
    }

/////////////////////////////////////////////////////////// doubleCapacity

    private void doubleCapacity(){
	int j = front;
	String[] copy = new String[data.length*2];
	
	for(int i = 0; i < data.length; i++){
	    if(j == data.length){
		j = 0;
	    }

	    copy[i] = data[j];
	    j++;
	}

	data = copy;
	front = 0;
	back = data.length/2-1;
    }
    
    public static void main(String []args){
    	MyDeque md = new MyDeque();
	for(int i = 0; i<20; md.addFirst("apple")) {i++;}
	System.out.println(md + " size: " + md.size());
	for (int i=0; i<100; md.addLast(md.removeFirst())) {i++;}
	System.out.println(md + " size: " + md.size());
	while (true)
	    try {
		md.removeFirst();
		md.removeLast();
	    } catch (NoSuchElementException e) {
		break;
	    }
	md.addFirst("banana");
	for (int i=0; i<16; md.addFirst(md.getFirst() + "na")) {i++;}
	System.out.println(md + " size: " + md.size());
	for (int i=0; i<8; md.addLast(md.getLast() + "na")) {i++;}
	System.out.println(md + " size: " + md.size());

    }
}
