import java.util.*;
import java.io.*;
public class Maze{
    private char[][]maze;
    private boolean animate;
    private int startX;
    private int startY;


    public Maze(String filename)throws FileNotFoundException {
	animate=false;
	File text = new File(filename); 
        Scanner inf = new Scanner(text);
        int rowNum = 0;
		int colNum = 0;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
	    rowNum++;
	    colNum=line.length();
	}
	inf.close();
	maze= new char[rowNum][colNum];
	inf = new Scanner(text);
	int row = 0;
	while(inf.hasNextLine()){
	    String line = inf.nextLine();
	    for(int col=0; col<line.length(); col++){
		maze[row][col]=line.charAt(col);
		if(line.charAt(col)=='S'){
		    startX=row;
		    startY=col;
		}

	    }
	    row++;
	}	
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }
    
    public void setAnimate(boolean b){
	animate = b;
    }

    public void clearTerminal(){
	System.out.println("\033[2J\033[1;1H");
    }

    public boolean solve(){
	int startr=startX;
	int startc=startY;
	maze[startr][startc]=' ';
	return solve(startr,startc);
    }

    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }
	if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length){
	    return false;
	}
	if (maze[row][col] == 'E'){
	    return true;
	}
	if(maze[row][col] == '#' || maze[row][col] == '.'){
	    return false;
	}
	if (maze[row][col] == ' '){
	    maze[row][col] = '@';
	    if (solve(row + 1, col) || solve(row, col + 1) || solve(row - 1, col) || solve(row, col - 1)){
		return true;
	    }
	    else{
		maze[row][col] = '.';
	    }
	}
        return false;
    }


    public String toString(){
	String res="";
	for(int r=0; r<maze.length; r++){
	    for(int c=0; c<maze[0].length; c++){
		res+=String.valueOf(maze[r][c]);
	    }
	    res+="\n";
	}
	return res;
    }

    public static void main(String args[])throws FileNotFoundException{
	
		Maze maze1 = new Maze("data3.dat");
	System.out.println(maze1);
	maze1.solve();
	System.out.println(maze1);
    }
}