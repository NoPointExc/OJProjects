import java.util.*;
public class Solution {
		//0,1,2,3
		//4,5,6
		//7,8,9
		//map[i][j]
	// private final static char[][] map = 
	// {{' ', ' ', ' ',' '}, {' ', ' ', ' ',' '},{'a', 'b', 'c',' '}, {'d','e','f',' '},
	// {'g', 'h', 'i',' '}, {'j', 'k', 'l',' '},{'m', 'n', 'o',' '}, 
	// {'p', 'q', 'r', 's'}, {'t', 'u', 'v',' '}, {'w', 'x', 'y', 'z'}};

	private final static String[] map={" ", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public List<String> letterCombinations(String digits) {				
		List<String> result= new ArrayList<String>();
		if(digits.length()==0) return result;
		int num=Integer.parseInt(digits);
		//StringBuilder buff=new StringBuilder();
		backTrack(num,result,"");
		return result;
	}

	private void backTrack(int num, List<String> result, String buff){
		int i= num%10;
		int size=3;		
		if(i==7||i==9)size=4;
		else if(i==0) size=1;
		else if(i==1) size=0;	
		for(int j=0;j<size&&num!=0;j++){
			//System.out.println(buff+map[i][j]);
			backTrack(num/10,result,map[i].charAt(j)+buff);
		}
		if(num==0)  result.add(buff); 
		//else backTrack(num/10, result,buff);
	}

}