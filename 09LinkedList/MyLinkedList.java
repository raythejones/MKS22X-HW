import java.util.*;
import java.io.*;

public class MyLinkedList {

    private class LNode {
	int value;
	 LNode next, prev;
	 
	public LNode(int value){
      this.value=value;
    }
    
    public String toString(){
      return value+"";
    }
	
	public LNode(int val, LNode node){
	    value = val;
	    next = node;
	}
    }
    
  LNode head,tail;
  int size;

    public MyLinkedList(){
	size = 0;
    }

 ////////////////////////////////////////////////////////////////////////   
    
	public int size(){
    return size;
    }
/*
 ////////////////////////////////////////////////////////////////////////   

    private LNode getNthNode(int n){
    	
    
    }

////////////////////////////////////////////////////////////////////////   
  
      private void addAfter(LNode location, LNode toBeAdded){


      }

////////////////////////////////////////////////////////////////////////   

  private void remove(LNode target){
  if(not a special case):
		x.next.prev = x.prev
		x.prev.next = x.nexts
  }
*/
 ////////////////////////////////////////////////////////////////////////   
    
    public String toString(){
	if (size == 0){
	    return "[]";
	}
	String i = "[";
	LNode current = head;
	while(current.next != null){
	    i += current.value + ", ";
	    current = current.next;
	}
	i += (current.value + "]");
	return i;
    }
    
 ////////////////////////////////////////////////////////////////////////   
    
    
    public int get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	
	LNode current = head;
	for (int i = 0; i < size; i ++){
	    if (i == index){
		return current.value;
	    }
	    else
		current = current.next;
	}
	return -1;
    }
 
 ////////////////////////////////////////////////////////////////////////   
   
    public int set(int index, int newValue){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	    
	LNode current = head;
	int oVal = get(index);
	for (int i = 0; i < index + 1; i ++){
	    if (i == index){
		current.value = newValue;
	    }
	    else{
		current = current.next;
	    }
	}
	return oVal;
    }
    
 ////////////////////////////////////////////////////////////////////////   

    public boolean add(int value){ 
	add(size(),value);
	return true;
    }
    
 ////////////////////////////////////////////////////////////////////////   
    
    public int indexOf(int value){
	LNode current = head;
	int i= 0;
	while(current != null){
	    if (current.value == value){
		return i;
	    }
	    else{
		current = current.next;
		i++;
	    }
	}
	return -1;
    }
    
  ////////////////////////////////////////////////////////////////////////    
    
    public int remove(int index){
	int val = get(index);
    	LNode current = head;
    	if(index < 0 || index >= size()){
    	    throw new IndexOutOfBoundsException();
    	}

	else if(size() == 1){
	    head = null;
	    tail = null;
	}

        else if (index == size()-1){
    	    for (int i = 0; i < size(); i ++){
    		if (i == index - 1){
    		    current.next = null;
    		    tail = current;
		    break;
    		}
    		current = current.next;
    	    }
    	}

    	else if (index == 0){
    	    head = head.next;
    	}

    	else{
    	    LNode node = head;
	    int i = 0;
	    while (node.next != null){
		if (i == index-1){
		    node.next = node.next.next;
		    break;
		}
		else node = node.next;
		i ++;
	    }
	}
	size --;
	return val;
    }
    
 ////////////////////////////////////////////////////////////////////////   
    
    public void add(int index, int value){
	LNode current = head;
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
        if (index == size()){
	    tail = new LNode(value, tail);
	    }
	
	if (index == 0){
	    head = new LNode(value, head);
	}
	else{
	    LNode node = head;
	    int i = 0;
	    while (node != null){
		if (i == index-1){
		    LNode temp = node.next;
		    node.next = new LNode(value);
		    node.next.next = temp;
		}
		else node = node.next;
		i ++;
	    }
	}
	size ++;
    }



 ////////////////////////////////////////////////////////////////////////   
    
    public static void main(String[] args){
    
    //What works?
    // I will delete them from this list when they work!
    // getNthNode 
    // addAfter 
    // remove a specific node
    
    
    
	MyLinkedList x = new MyLinkedList();
	x.add(1);
	x.add(2);
	x.add(3);
	x.add(4);
	x.add(1,5);
	x.add(2,42);
	System.out.println(x.indexOf(2));
	
	System.out.println(x);
	
	System.out.println(x);
	x.set(2, 4);
		System.out.println(x);
		x.set(1, 1000000);
	
			System.out.println(x.get(1));
				x.set(4, 999999);
		
				System.out.println(x);	
	
    }
}