/*
1. Frontier interface (see image)

2. Location (see image) [ I merged the node and location classes. this makes the Location store a little bit extra]
ADD THE FOLLOWING:
2a implements Comparable<Location>
2b instance variables:
 private int distToGoal (to store a reference to the goal)
 private boolean aStar : when this is true, compareTo will use the previousDistance + distanceToGoal
                                     when this is false, compareTo will use the distanceToGoal only.
                                     
2c Constructors:
 Location(int r, int c, Location previous,  int distToStart, int distToGoal)  
 Location(int r, int c, Location previous , int distToStart, int distToGoal, boolean aStar)

2d Methods: (accessors as needed)
  CompareTo( Location other) -> decide what number to compare using the aStar boolean.

2. FrontierPriorityQueue - implements Frontier
      This is just your Priority queue that implements Frontier ( add/next).

3. QueueFrontier - implements Frontier
       Store a Queue instance variable and write methods for it.

4. StackFrontier - implements Frontier
       Store a Stack instance variable and write methods for add/next.

5. MazeSolver
  
5a constructors:
MazeSolver(String filename) : filename - input name of the maze file.
MazeSolver(String filename, boolean animate) : filename - input name of the maze file, animate - true for animating your maze.

5b public methods:
  solve() - call solve(1)
  solve(int style) - style is 0-3, where 0-DFS, 1-BFS,2-BestFirst, 3-A*
     This method will instantiate the Frontier based on which style was chosen. 
     It will then add the starting location of the maze to the Frontier.
     Finally it will process each subsequent element of the frontier until the end is found. 
   

  toString() - the toString of the maze instanceVariable.

    addToFrontier - change the maze to a '?'

6. Maze - Will be given to you. */


import java.lang.*;
public class MazeSolver {

    private Maze maze;
    private boolean a;
     

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename);
	a = animate;
    }
    
    public int howFar(int r, int c, Location b){
	return (Math.abs(b.getRow() - r) + Math.abs(b.getCol() - c));
    }
    
    public void solve() {
	solve(1);
    }
    
     public void solve(int i) {
	if (i == 0) { //DFS
	    StackFrontier q = new StackFrontier();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToGoal = 0;
	    while (q.getSize() > 0) {
	    
// delay for testing
    try {
        System.out.println("Solving...");
        Thread.sleep(25); 
    } catch (InterruptedException ex) {
        // handle error
    }		
    	    
	    
		Location temp = q.next();
		if(howFar(temp.getRow(), temp.getCol(), maze.getEnd()) == 0){
		    maze.set(temp.getRow(), temp.getCol(), 'E');
		    System.out.println(this);
		    return;
		}
		try{
		    if(maze.get(temp.getRow() + 1, temp.getCol()) == ' '){
			int r = temp.getRow() + 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow() - 1, temp.getCol()) == ' '){
			int r = temp.getRow() - 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() + 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() - 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getRow(), temp.getCol(), '.');
		System.out.println(this);
	    }	
	}
	if (i == 1) { //BFS
	    QueueFrontier q = new QueueFrontier();
	    q.add(maze.getStart());
	    int distToStart = 0;
	    int distToGoal = 0;
	    while (q.getSize() > 0) {
	    
// delay for testing
    try {
        System.out.println("Solving...");
        Thread.sleep(25); 
    } catch (InterruptedException ex) {
        // handle error
    }		
    
    
    Location temp = q.next();
		if(howFar(temp.getRow(), temp.getCol(), maze.getEnd()) == 0){
		    maze.set(temp.getRow(), temp.getCol(), 'E');
		    System.out.println(this);
		    return;
		}
		try{
		    if(maze.get(temp.getRow() + 1, temp.getCol()) == ' '){
			int r = temp.getRow() + 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow() - 1, temp.getCol()) == ' '){
			int r = temp.getRow() - 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() + 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() - 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getRow(), temp.getCol(), '.');
		System.out.println(this);
	    }  	
	}
	if (i == 2) { //BestFirst
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    int distToStart;
	    int distToGoal;
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if(howFar(temp.getRow(), temp.getCol(), maze.getEnd()) == 0){
		    maze.set(temp.getRow(), temp.getCol(), 'E');
		    System.out.println(this);
		    return;
		}
		distToStart = howFar(temp.getRow(), temp.getCol(), maze.getStart());
		distToGoal = howFar(temp.getRow(), temp.getCol(), maze.getEnd());
		try{
		    if(maze.get(temp.getRow() + 1, temp.getCol()) == ' '){
			int r = temp.getRow() + 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow() - 1, temp.getCol()) == ' '){
			int r = temp.getRow() - 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() + 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() - 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,false));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getRow(), temp.getCol(), '.');
		System.out.println(this);
	    }	
	}
	if (i == 3) { //A*
	    FrontierPriorityQueue q = new FrontierPriorityQueue();
	    q.add(maze.getStart());
	    int distToStart;
	    int distToGoal;
	    while (q.getSize() > 0) {
		Location temp = q.next();
		if(howFar(temp.getRow(), temp.getCol(), maze.getEnd()) == 0){
		    maze.set(temp.getRow(), temp.getCol(), 'E');
		    System.out.println(this);
		    return;
		}
		distToStart = howFar(temp.getRow(), temp.getCol(), maze.getStart());
		distToGoal = howFar(temp.getRow(), temp.getCol(), maze.getEnd());
		try{
		    if(maze.get(temp.getRow() + 1, temp.getCol()) == ' '){
			int r = temp.getRow() + 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		}
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow() - 1, temp.getCol()) == ' '){
			int r = temp.getRow() - 1;
			int c = temp.getCol();
		        q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() + 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() + 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		try{
		    if(maze.get(temp.getRow(), temp.getCol() - 1) == ' '){
			int r = temp.getRow();
			int c = temp.getCol() - 1;
			q.add(new Location(r,c,temp,distToStart,distToGoal,true));
			maze.set(r,c,'?');
		    }
		}catch (IndexOutOfBoundsException e){}
		maze.set(temp.getRow(), temp.getCol(), '.');
		System.out.println(this);
	    }	
	}
    }

    public String toString() {
	return maze.toString();
    }
    
    public static void main(String[]args){
    MazeSolver m = new MazeSolver("data3.txt");
m.solve(0);
    }

}