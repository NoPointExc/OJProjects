import java.util.*;

public class Solution {
    private final static int[][] DIRECTION = {{1,0},{-1,0},{0,1},{0,-1}};

    class Trie{
	Trie[] nexts;
	String word;

	public Trie(){
	    nexts = new Trie[26];
	}

	public Trie(String[] words){
	    this.nexts = new Trie[26];

	    for(String word:words){
		Trie p = this;
		for(int i=0;i<word.length();i++){
		    if(p.nexts[word.charAt(i)-'a'] == null)
			p.nexts[word.charAt(i)-'a'] = new Trie();

		    p = p.nexts[word.charAt(i)-'a'];
		}
		p.word = word;
	    }

	}
    }

    public List<String> findWords(char[][] board, String[] words) {
	List<String> list = new ArrayList<>();
	if(board.length == 0 || board[0].length == 0)
	    return list;
	Trie root = new Trie(words);
	
	for(int i=0;i<board.length;i++)
	    for(int j=0;j<board[0].length;j++){
		boolean[][] visited = new boolean[board.length][board[0].length];
		visited[i][j] = true;
		backTracking(board,visited,i,j,root,list);	
	    }
	return list;
    }

    private void backTracking(char[][] board, boolean[][] visited, int x, int y,Trie trie,List<String> list){
	//System.out.println("x="+x+" y="+y);
	if(trie == null)
	    return;

	trie = trie.nexts[ board[x][y] -'a']; 
	for(int i=0;i<DIRECTION.length;i++){
	    int nextX = x + DIRECTION[i][0];
	    int nextY = y + DIRECTION[i][1];
	    if(nextX>=0 && nextX<board.length && nextY>=0 && nextY<board[0].length && !visited[nextX][nextY]){
		visited[nextX][nextY] = true;
		backTracking(board,visited,nextX,nextY,trie,list);
		visited[nextX][nextY] = false;
	    } 
	}

	if(trie!= null && trie.word!=null){
	    list.add(trie.word);
	    trie.word = null;
	}

    }

    public static void main(String[] args){
	Solution s = new Solution();
	//char[][] board= {
	//    {'o','a','a','n'},
	//    {'e','t','a','e'},
	//    {'i','h','k','r'},
	//    {'i','f','l','v'}
	//};

	char[][] board = {{'a'},{'a'}};	
	String[] words = {"a","aa","aaa","aa","if","oath","pea","eat","rain"};
	List<String> rst = s.findWords(board,words);	
	System.out.println("rst=" + rst);
    }
}
