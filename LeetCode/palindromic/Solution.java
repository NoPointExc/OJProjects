
public class Solution {
    public String longestPalindrome(String s) {
		int h=0,t=s.length()-1;
		String lpal="";
		String tmp="x";
		System.out.println("h>"+h+"  ,t>"+t);
		if(t==h) return s.substring(t,h);
		if(s.charAt(h)==s.charAt(t)) {

			tmp=longestPalindrome(s.substring(h+1,t-1));//bug
			tmp=s.charAt(h)+tmp+s.charAt(t);
			System.out.println("*tmp="+tmp);
			if(tmp.length()> lpal.length()) lpal= tmp;
		}else{
			System.out.println("*"+s.substring(h+1,t+1));
			tmp=longestPalindrome(s.substring(h+1,t+1));
			System.out.println("**tmp="+tmp);
			if(tmp.length()> lpal.length()) lpal= tmp;			
			tmp=longestPalindrome(s.substring(h,t));
			System.out.println("***tmp="+tmp);
			if(tmp.length()> lpal.length()) lpal= tmp;
		}
		//System.out.println(lpal);
		return lpal;	
    }
}