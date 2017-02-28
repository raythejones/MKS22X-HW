public class KnightBoard{
    private int[][]board;

    public KnightBoard(int n, int m){
	board = new int[m][n];
	
    }
    
    private void clear(){
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                board[k][i] = 0;
            }
        }
    }
    
    public String toString(){
	String ans = "";
	for(int col = 0; col<board.length;col++){
	    for(int row = 0; row<board[col].length;row++){
		ans += " ";
		if (board[col][row] == 0){
		    ans += "_";
		}
		else{
		    if(board[col][row] < 10){
		    ans += " " + board[col][row];
			
		    }
		    else{ans += "" + board[col][row];}
		}
	    }
	    ans += "\n";
	}
	return ans;
    }

    private boolean goodSpace(int col,int row){
	return board[col][row] == 0;
	
    }

    public void addKnight(int row, int col, int id){
	board[col][row] = id;
    }

    public void removeKnight(int row, int col, int id){
	board[col][row] = 0;
    }

    public boolean solve(){
	solveH(0,0,1);
	return true;
    }
    private boolean solveH(int row, int col, int id){
	// are we done?
	if(id > board.length * board.length){
            return true;
        }
	//index in bounds?
        if(col >= board.length || col < 0 || row >= board.length || row < 0){
            return false;
        }
        if(board[col][row] == 0){
            board[col][row] = id;
            if(solveH(row+2, col+1, id+1) || solveH(row+1, col+2, id+1) || solveH(row-2, col-1, id+1) || 
	       solveH(row-1, col+2, id+1) || solveH(row-1, col-2, id+1) || solveH(row+2, col-1, id+1) || 
	       solveH(row-2, col+1, id+1) || solveH(row+1, col-2, id+1)){
                return true;
            }
            board[col][row] = 0;
        }
        return false;
    }
    
    public boolean done(int row, int col, int id){
	if(id >= row * col){
	    return true;
	}
	else{
	    return false;}
    }
	
    public static void main(String[]args){
        KnightBoard a = new KnightBoard(5,5);
        a.solve();
        System.out.println(a);

    }
}
