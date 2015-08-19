import java.util.*;
public class Solution {
    public void solveSudoku(char[][] board) {
    	Stack<Integer> x=new Stack<Integer>();
    	Stack<Integer> y=new Stack<Integer>();
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			if(board[i][j]=='.'){
    				x.add(i);
    				y.add(j);
    				}
    			}
    		}
    	solveSudoku(board,x,y);
    }
    

    public boolean solveSudoku(char[][] board,Stack<Integer> x, Stack<Integer> y){
    	if(x.isEmpty()) return true;
    	int nextX=x.pop();
    	int nextY=y.pop();
    	for(char i='1';i<='9';i++){
    		if(isVaild(board,nextX,nextY,i)){
    			board[nextX][nextY]=i;
    			if(solveSudoku(board,x,y)) return true;
    			else board[nextX][nextY]='.';
    		}
    	}
    	x.push(nextX);
    	y.push(nextY);
    	return false;
    }


    //whether fill val in board[x][y] is vaild.  
    public boolean isVaild(char[][] board, int x,int y,char val){
    	for(int i=0;i<9;i++)
    		if(board[x][i]==val|| board[i][y]==val || board[3*(x/3)+i%3][3*(y/3)+i/3] ==val ) return false;
    	return true;
    }

}