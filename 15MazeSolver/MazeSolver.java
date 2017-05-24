/*
1. Frontier interface (see image)

2. Location (see image) [ I merged the node and location classeStart. this makes the Location store a little bit extra]
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
import java.util.*;
public class MazeSolver {

    private Maze maze;
    private boolean a;
    private Location Start;
    private Location End;

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	maze = new Maze(filename);
	a = animate;
	Start = maze.getStart();
	End = maze.getEnd();
    }
    
    public int howFar(int r, int c, Location b){
	return (Math.abs(b.getRow() - r) + Math.abs(b.getCol() - c));
    }
    
    public void solve() {
	solve(1);
    }
    
    public void solve(int x){
	Frontier a;
	if (x==0){
	    a = new StackFrontier();
	}
	else if (x==2||x==3){	    
	    a = new FrontierPriorityQueue();		
	}
	else{
	    a = new QueueFrontier();
	}
	a.add(Start);
	boolean b = false;
	if (x ==3){
	    b = true;
	}
	while (a.getSize() > 0){
	    Location temp = a.next();
	    
	    		if(howFar(temp.getRow(), temp.getCol(), maze.getEnd()) == 0){
		    maze.set(temp.getRow(), temp.getCol(), 'E');
		     temp = temp.getPrevious();
   while (!temp.getPrevious().equals(maze.getStart())) {
			maze.set(temp.getRow(), temp.getCol(), '@');
			temp = temp.getPrevious();
			System.out.println(maze.toString(100));
		    }
		    maze.set(temp.getRow(), temp.getCol(), '@');
    maze.set(maze.getStart().getRow(), maze.getStart().getCol(), 'S');
		System.out.println(maze.toString(100));
		    return;
		}
	    maze.set(temp.getRow(),temp.getCol(),'.');
	    
//	if( x == 0 || x == 1){
	    
///int dUp = howFar(temp.getRow() - 1,temp.getCol(), eEnd);
//int dDown = howFar(temp.getRow() + 1,temp.getCol(), eEnd);
//int dRight = howFar(temp.getRow(),temp.getCol() + 1, eEnd);
//int dLeft = howFar(temp.getRow(),temp.getCol() - 1, eEnd);

//int minVal = minValid();

	    if (maze.get(temp.getRow()+1,temp.getCol())==' '){
		a.add(new Location(temp.getRow()+1,temp.getCol(),temp,Math.abs(temp.getRow()+1-Start.getRow())+Math.abs(temp.getCol()-Start.getCol()),Math.abs(temp.getRow()+1-End.getRow())+Math.abs(temp.getCol()-End.getCol()),b));
		maze.set(temp.getRow()+1,temp.getCol(),'?');
	    }
	    if (maze.get(temp.getRow()-1,temp.getCol())==' '){
		a.add(new Location(temp.getRow()-1,temp.getCol(),temp,Math.abs(temp.getRow()-1-Start.getRow())+Math.abs(temp.getCol()-Start.getCol()),Math.abs(temp.getRow()-1-End.getRow())+Math.abs(temp.getCol()-End.getCol()),b));
		maze.set(temp.getRow()-1,temp.getCol(),'?');
	    }
	    if (maze.get(temp.getRow(),temp.getCol()+1)==' '){
		a.add(new Location(temp.getRow(),temp.getCol()+1,temp,Math.abs(temp.getRow()-Start.getRow())+Math.abs(temp.getCol()+1-Start.getCol()),Math.abs(temp.getRow()-End.getRow())+Math.abs(temp.getCol()+1-End.getCol()),b));
		maze.set(temp.getRow(),temp.getCol()+1,'?');
	    }
	    if (maze.get(temp.getRow(),temp.getCol()-1)==' '){
		a.add(new Location(temp.getRow(),temp.getCol()-1,temp,Math.abs(temp.getRow()-Start.getRow())+Math.abs(temp.getCol()-1-Start.getCol()),Math.abs(temp.getRow()-End.getRow())+Math.abs(temp.getCol()-1-End.getCol()),b));
		maze.set(temp.getRow(),temp.getCol()-1,'?');
	    }
	    System.out.println(maze.toString(100));
	}	//	 		}			  

//if( x == 2){
 
//}


}

/*
public Location minValid(int ro, int co, int u, int d, int l, int r){
int[] dists = {u, d, l, r};
Arrays.sort(dists);

for(int i = 0; i < 4; i++){
	
}


ArrayList loc = new ArrayList();

Arrays.sort(dists);

if dists[0]

return best;
}
*/
    public String toString() {
	return maze.toString();
    }
    
    public static void main(String[]args){


    MazeSolver m = new MazeSolver(args[0]);
m.solve(Integer.parseInt(args[1]));
    }

}
