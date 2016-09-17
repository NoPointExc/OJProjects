import java.util.*;

public class Solution {
    private static final int[][] DIRECTION = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<String> findWords(char[][] board, String[] words) {
	List<String> rst = new ArrayList<String>();
	if(board.length ==0 || board[0].length == 0)
	    return rst;
	
	HashSet<String> set = new HashSet<>();
	for(String word:words){
	    boolean isFind = false;
	    for(int i=0;i<board.length && !isFind;i++){
		for(int j=0;j<board[0].length && !isFind;j++){
		    boolean[][] visited =new boolean[board.length][board[0].length];
		    visited[i][j] = true;
		    isFind = backTracking(board,visited,i,j,word,0);
		}
	    }

	    if(isFind){
		set.add(word);
	    }
	}
	
	rst = new ArrayList<>(set);
	return rst;
    }

    // current visit x, y, expect board[x][y] == word.charAt(k)
    private boolean backTracking(char[][] board, boolean[][] visited, int x, int y,String word, int k){
	
	if(k==word.length()-1){
	   return board[x][y] == word.charAt(k); 
	}else if(board[x][y]==word.charAt(k)){

	    for(int i=0;i<DIRECTION.length;i++){
		int nextX = x+DIRECTION[i][0];
		int nextY = y+DIRECTION[i][1];
		if(nextX>=0 && nextX<board.length && nextY>=0 && nextY<board[0].length && !visited[nextX][nextY]){
		    visited[nextX][nextY] = true;
		    boolean rst = backTracking(board,visited,nextX,nextY,word,k+1);
		    if(rst == true) 
			return true;
		    visited[nextX][nextY] = false;
		}
	    }

	}

	return false;

    }

    public static void main(String[] args){
	Solution s = new Solution();
	//char[][] board= {
	 //   {'o','a','a','n'},
	   // {'e','t','a','e'},
	    //{'i','h','k','r'},
	    //{'i','f','l','v'}
	//};

	char[][] board = {{'a'},{'a'}};	
	String[] words = {"a","aaa","if","oath","pea","eat","rain"};
	List<String> rst = s.findWords(board,words);	
	System.out.println("rst=" + rst);
   }
}
