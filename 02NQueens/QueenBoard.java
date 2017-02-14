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

    public static void main(String[] args){

	QueenBoard a = new QueenBoard(2);
	a.solve();
	System.out.println(a);
	System.out.println("\n");
	System.out.println("\n");
	
	QueenBoard b = new QueenBoard(16);
        b.solve();
	System.out.println(b);
	System.out.println("\n");
		System.out.println("\n");

	QueenBoard c = new QueenBoard(4);
        c.solve();
	System.out.println(c);

}
}

