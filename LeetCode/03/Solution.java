/**
*Given a string, find the length of the longest substring without repeating characters. For example, the longest 
*substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest 
*substring is "b", with the length of 1.
*/

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {//abba
      	int first=0, size=0, len=s.length(); //len=4
      	Map<Character,Integer> mp=new HashMap<>(); //V is the last apper of K
      	for(int i=0;i<len;i++){ //i=0,1,2,3
      		Character c=(Character)s.charAt(i);
      		if(mp.containsKey(c)&&mp.get(c)>=first) first=mp.get(c)+1; 
      		mp.put(c,i);
      		if(size<(i-first+1)) size=i-first+1;
      	}
    return size;
    }
}