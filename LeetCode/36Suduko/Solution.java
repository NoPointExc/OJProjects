import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
  		Set<Character> row=new HashSet<Character>();
		Set<Character> col=new HashSet<Character>();
		Set<Character> cell=new HashSet<Character>();
  		for(int i=0;i<9;i++){
  			//row,col, cell  
  			row.clear();
  			col.clear();
  			cell.clear();
  			for(int j=0;j<9;j++){
  				//System.out.print("row:"+board[i][j]);
  				//System.out.print(" col:"+board[j][i]);
  				//System.out.println(" cell:"+board[i/3*3+j/3][i%3*3+j%3]);
	  			if(!row.add(board[i][j])&&board[i][j]!='.') {
	  				//System.out.print("row:"+board[i][j]);
	  				return false;
	  			}
	  			if(!col.add(board[j][i])&&board[j][i]!='.') {
	  				//System.out.print(" col:"+board[j][i]);
	  				return false;
	  			}
	  			if(!cell.add(board[i/3*3+j/3][i%3*3+j%3])&&board[i/3*3+j/3][i%3*3+j%3]!='.') {
	  				//System.out.println(" !!!cell:"+board[i/3*3+j/3][i%3+j%3]);
	  				//System.out.println("cell x:"+(i/3*3+j/3)+"y"+(3*i%3+j%3));
	  				//System.out.print(cell);
	  				return false;
	  			}
  			}
  		}
  		return true;
    }
}