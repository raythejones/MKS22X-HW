import java.util.*;
import java.io.*;

public class USACO{
    public USACO(){
    }
    
    public int bronze(String filename){
	try{
	    File infile = new File(filename);
	    Scanner inf = new Scanner(infile);
	    String header = inf.nextLine();

	    Scanner getInput = new Scanner(header);
	    int R = getInput.nextInt();
	    int C = getInput.nextInt();
	    int E = getInput.nextInt();
	    int N = getInput.nextInt();

//initialize lake
	    int[][] lake = new int[R][C];
	    for(int row = 0; row<R; row++){
		String elavs = inf.nextLine();
		Scanner elavsScan = new Scanner(elavs);
		for(int col = 0; col<C; col++){
		    lake[row][col] = elavsScan.nextInt();
		}
	    }

	    while(inf.hasNextLine()){
		String inString = inf.nextLine();
		Scanner inStringScan = new Scanner(inString);
		int RScanned = inStringScan.nextInt();
		int CScanned = inStringScan.nextInt();
		int DScanned = inStringScan.nextInt();


		int highPoint = lake[RScanned-1][CScanned-1];
		for(int row = RScanned-1; row<RScanned+2; row++){
		    for(int col = CScanned-1; col<CScanned+2; col++){
			if(lake[row][col] > highPoint){
			    highPoint = lake[row][col];
			}
		    }
		}
		int supposedEl = highPoint - DScanned;
		for(int row = RScanned-1; row<RScanned+2; row++){
		    for(int col = CScanned-1; col<CScanned+2; col++){
			if(lake[row][col] > supposedEl){
			    lake[row][col] = supposedEl;
			}
		    }
		}
	    }
//final answer:
	    int resultDepth = 0;
	    for(int r = 0; r<R; r++){
		for(int c = 0; c<C; c++){
		    if(lake[r][c] < E){
			resultDepth += E - lake[r][c];
		    }
		}
	    }
	     resultDepth = resultDepth * 72 * 72;
	return resultDepth;
	
	}
	
//if the files not there	
	catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return -1;
    }
    
    

    public int silver(String filename){
	try{
	    File infile = new File(filename);
	    Scanner inf = new Scanner(infile);
	    String header = inf.nextLine();

	    Scanner headerS = new Scanner(header);
	    int N = headerS.nextInt();
	    int M = headerS.nextInt();
	    int T = headerS.nextInt();

	    int[][] past1 = new int[N][M];
	    int[][] past2 = new int[N][M];
	    for(int r = 0; r < N; r++){
		String row = inf.nextLine();
		for(int c = 0; c < M; c++){
		    String charac = row.substring(c, c+1);
		    if(charac.equals("*")){
			past1[r][c] = -1;
			past2[r][c] = -1;
		    }if(charac.equals(".")){
			past1[r][c] = 0;
			past2[r][c] = 0;
		    }
		}
	    }

	    String info = inf.nextLine();
	    Scanner infoS = new Scanner(info);
	    int R1 = infoS.nextInt()-1;
	    int C1 = infoS.nextInt()-1;
	    int R2 = infoS.nextInt()-1;
	    int C2 = infoS.nextInt()-1;

	    for(int time = 0; time <= T; time++){
		if(time == 0){
		    past2[R1][C1] = 1;
		}else if(time%2 != 0){
		    for(int r = 0; r < N; r++){
			for(int c = 0; c < M; c++){
			    if(past2[r][c] != 0 && past2[r][c] != -1){
				past1[r][c] = 0;
			    }if(past1[r][c] != -1){
				past1[r][c] = findMoves(r, c, past2);
			    }
			}
		    }
		}else{
		    for(int r = 0; r < N; r++){
			for(int c = 0; c < M; c++){
			    if(past1[r][c] != 0 && past2[r][c] != -1){
				past2[r][c] = 0;
			    }if(past2[r][c] != -1){
				past2[r][c] = findMoves(r, c, past1);
			    }
			}
		    }
		}
	    }
	    if(T%2 == 0){
		return past2[R2][C2];
	    }else{
		return past1[R2][C2];
	    }
		
	}catch(FileNotFoundException e){
	    System.out.println("File not found.");
	    System.exit(0);
	}
	return -1;
    }

    public int findMoves(int r, int c, int[][] pasture){
	int total = 0;
	if(r > 0 && pasture[r-1][c] != -1){ 
	    total += pasture[r-1][c];
	}if(r < pasture.length-1 && pasture[r+1][c] != -1){
	    total += pasture[r+1][c];
	    
	    
	    
	}if(c > 0 && pasture[r][c-1] != -1){
	    total += pasture[r][c-1];
	}if(c < pasture[0].length-1 && pasture[r][c+1] != -1){
	    total += pasture[r][c+1];
	}
	return total;
    }
		    

    public static void main(String[] args){
  }

    
}