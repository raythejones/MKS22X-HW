import java.util.*;
public class Location implements Comparable<Location>{

 private int row,col;
 private int distToGoal;
 private int distToStart; 
 private Location previous; //(used to trace the solution)
 private boolean aStar; // when true, compareTo is distToStart + distToGoal
                           //          when false, compareTo is distToGoal.


    public Location(int r, int c, Location prev, int distStart, int distEnd) {
	row = r;
	col = c;
	previous = prev;
	distToGoal = distEnd;
	distToStart = distStart;
    }
     
 public Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar){
row = r;
col = c;
 this.distToGoal = distToGoal;
 this.distToStart = distToStart;
 this.previous = previous; 
 this.aStar = aStar;
 }
        
                                   
   public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public int getDistToGoal(){
	return distToGoal;
    }
    
    public int getDistToStart(){
	return distToStart;
    }

    public Location getPrevious(){
	return previous;
    }

    
	public boolean getStar() {
	return aStar;
    }
    
    public int compareTo(Location other){
	if(aStar){
	    return (getDistToGoal() + getDistToStart()) - (other.getDistToGoal() + other.getDistToStart());
	}
	else {
	    return getDistToGoal() - other.getDistToGoal();
	}
    }
	
}