
public class Solution {
    public String longestPalindrome(String s) {
	int max=0;//max wing length of sub palindrome
	int maxCen=0;
	if(s==null || s.length()<=1 ) return s;
	for(int i=0;i<s.length()-max;i++){
		int range=max;
		while(range>0 && s.charAt(i-range)==s.charAt(i+range)){
			range--;
		}
		//scan out range
		if(range==0){
			range=max+1;
			while(range<=i && i+range<s.length() && s.charAt(i-range)==s.charAt(i+range)){
				range++;
			}
			max=range;
			maxCen=i;
		}
	}
	return s.substring(maxCen-max+1,maxCen+max);
    }
}
