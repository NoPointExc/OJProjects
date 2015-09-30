import java.util.*;
public class Solution {
    public String minWindow(String s, String t) {
        //System.out.println(s);
        int next=0, p=0;
        int min=s.length();
        int start=0,end=0;
        char[] tar=t.toCharArray();
        Set<Character> dict=new HashSet<Character>();
        for(char i:tar) dict.add(i);
        char[] str=s.toCharArray();
    	for(int i=0;i<s.length();i++){
    		//System.out.println("min="+min);
    		int mark=i;
    		if(dict.contains(str[i])){
    			//start=i;
    			Set<Character> has=new HashSet<Character>();
    			has.add(str[i]);
    			int j=i+1;
    			for(;j<str.length && has.size()<tar.length;j++){
    				if(dict.contains(str[j])&& !has.contains(str[j])){
    					has.add(str[j]);
    				}
    			}
    			if(has.size()==tar.length && j-i<min ) {
    				min=j-i;
    				start=i;
    				end=j;
    			}    			
    		}
    	}
    	return s.substring(start,end);
    }
}