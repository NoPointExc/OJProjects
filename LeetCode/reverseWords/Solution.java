/**
*Given an input string, reverse the string word by word.
*For example,
*Given s = "the sky is blue",
*return "blue is sky the".
*/


public class Solution {
    public String reverseWords(String s) {
    	StringBuilder sb=new StringBuilder();
    	int i=s.length()-1, j=s.length();
    	while(i>-1){
    		while(i!=-1&&s.charAt(i)!=' ') i--;
    		sb.append(s.substring(i+1,j));
			if(s.charAt(j-1)!=' ') sb.append(" ");    		
    		j=i; i--;
    	}
    	return sb.toString().trim();
    }
}