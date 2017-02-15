public class KnightBoard{
    private board[][];

    public KnightBoard(int n){
	board[][] = new int[n][n]
	
	    }

    public String toString(){
	String ans = "";
	for(int col = 0; col<board[row].length;col++){
	    for(int row = 0; row<board.length;row++){
		ans += " ";
		if (board[row][col] == 0){
		    ans += "_";
		}
		else{
		    ans += "" += board[col][row];
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    private boolean goodSpace(col, row){
	return board[col][row] === 0;
	
    }

    public void addKnight(row, col, id){
	board[col][row] = id;
    }

    public void removeKnight(row, col, id){
	board[col][row] = 0;
    }

    public boolean solve(){
	this.SolveH(0);
	return true;
    }
 
    public boolean solveH(row, col, id){
	if(done(id)){return true;}
	if(goodSpace(col, row)){
	    addKnight(row, col, id);

	    if(board[col+2][row+1] == 0){
		board[col+2][row+1] = id;
		solveH(row+1, col+2, id+1)
		    return true;}
	    
	    if(board[col+1][row+2] == 0){
		board[col+1][row+2] = id;
		solveH(row+2, col+1, id+1)
		    return true;}
	    
	    if(board[col-2][row-1] == 0){
		board[col-2][row-1] = id;
		solveH(row-1, col-2, id+1)
		    return true;}
	    
	    if(board[col-1][row-2] == 0){
		board[col-1][row-2] = id;
		solveH(row-2, col-1, id+1)
		    return true;}
	    
	    if(board[col-2][row+1] == 0){
		board[col-2][row+1] = id;
		solveH(row+1, col-2, id+1)
		    return true;}
	    
	    if(board[col+2][row-1] == 0){
		board[col+2][row-1] = id;
		solveH(row-1, col+2, id+1)
		    return true;}
	    
	    if(board[col+1][row-2] == 0){
		board[col+1][row-2] = id;
		solveH(row-2, col+1, id+1)
		    return true;}
	    
	    if(board[col-1][row+2] == 0){
		board[col-1][row+2] = id;
		solveH(row+2, col-1, id+1)
		    return true;}
	    else{
	    removeKnight(row, col, id){
		return false;}
	    }}
    }
    

	public boolean done(row, col, id){
	    if(id >= row * col){
		return true
		    }
	    else{
		return false}
	}
	
	public static void main(String[]args){
	}
    }
