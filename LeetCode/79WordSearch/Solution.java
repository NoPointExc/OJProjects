import java.util.*;

public class Solution {
	private char[][] board;
	private String word;
    public boolean exist(char[][] board, String word) {
    	this.board=board;
    	this.word=word;
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[i].length;j++){
    			if(exist(i,j,0)) return true;
    		}
    	} 
    	return false;  
    }

	private boolean exist(int x, int y, int p){
		//System.out.println("x="+x+"y="+y+"p="+p);
		//print(board);
		if(p==word.length()) return true;
		if(x<0 ||y<0|| x>=board.length||y>=board[x].length) return false;
		if(board[x][y]==word.charAt(p)){
			board[x][y]='*';
			if(exist(x-1,y,p+1) || exist(x+1, y,p+1) || exist(x,y-1,p+1) || exist(x,y+1,p+1))
				return true;
			else board[x][y]=word.charAt(p);		
		}
		return false;
	}
}