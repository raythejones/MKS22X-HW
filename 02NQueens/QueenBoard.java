public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int n){
	board = new int[n][n];
	
	solutionCount = -1;
    }
    
 public String toString(){
	String ans = "";
	for(int col = 0; col<board.length;col++){
	    for(int row = 0; row<board.length;row++){
	    ans += " ";
		if (board[row][col] == -1){
		    ans += "Q";
		}
		else{
		    ans += "_";
		}
	    }
	    ans += "\n";
	}
	return ans;
    }
    
    
    // clear method, sets everything back to 0
private void clear(){
	for(int col = 0; col < board.length; col++){
	    for(int row = 0; row < board.length; row++){
		board[col][row] = 0;
	    }
	}
    }
    
    public boolean solve(){
	this.SolveH(0);
	return true;
    }
 
    
        private boolean SolveH(int column){
	if(column == board.length){
	    return true;
	}
	for(int row = 0; row < board.length; row++){
	    if(board[column][row] == 0){
		addQueen(column, row);
		if(SolveH(column + 1)){
		    return true;
		}
		removeQueen(column, row);
	    }
	}
	return false;
    }

    

    private boolean isSafeSpace(int r, int c){
	return board[r][c] == 0;
    }
 
    

    public void addQueen(int col, int row){
       	for(int i = 0; i < board.length; i++){
	    board[col][i]++;
	    board[i][row]++;
	    if(row - col + i < board.length && row - col + i >= 0){
		board[i][row - col + i]++;
	    }
	    if(row + col - i < board.length && row + col - i >= 0){
		board[i][row + col - i]++;
	    }
	    board[col][row] = -1;
	}
    }

    public void removeQueen(int col, int row){
       	for(int i = 0; i < board.length; i++){
	    board[col][i]--;
	    board[i][row]--;
	    if(row - col + i < board.length && row - col + i >= 0){
		board[i][row - col + i]--;
	    }
	    if(row + col - i < board.length && row + col - i >= 0){
		board[i][row + col - i]--;
	    }
	    board[col][row] = 0;
	}
    }
    
    
        public void countSolutions(){
	clear();
	solutionCount = 0;
	calculateCount(0);
    }
    
    public int getSolutionCount(){
    	return solutionCount;
    }
    
    
    private void calculateCount(int c){
	for(int r = 0; r < board.length; r++){    
	    if(board[c][r] == 0){
		addQueen(c,r);
		if(c == board.length - 1){
		    solutionCount++;
		}
		else{
		    calculateCount(c + 1);
		}
		removeQueen(c,r);
		
	    }			
	}
    }
        

    public static void main(String[] args){
/*
	QueenBoard a = new QueenBoard(2);
	a.solve();
	System.out.println(a);
	System.out.println("\n");
	
	QueenBoard b = new QueenBoard(16);
        b.solve();
	System.out.println(b);
	System.out.println("\n");
		System.out.println("\n");

	QueenBoard c = new QueenBoard(4);
        c.addQueen(0,2);
        	System.out.println(c);
	System.out.println("\n");

	        c.addQueen(1,1);
	        	System.out.println(c);
	System.out.println("\n");

        c.addQueen(3,2);
        	System.out.println(c);
	System.out.println("\n");

        c.removeQueen(1,1);
        	System.out.println(c);
	System.out.println("\n");

        c.clear();

	System.out.println(c);
	System.out.println("\n");
*/

}
}

