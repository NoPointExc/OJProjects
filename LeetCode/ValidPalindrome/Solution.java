/**
*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
*For example,
*"A man, a plan, a canal: Panama" is a palindrome.
*"race a car" is not a palindrome.
*/
//System.out.println("i="+Character.toUpperCase(s.charAt(i))+"  ,j="+Character.toUpperCase(s.charAt(j)));

public class Solution {
    public boolean isPalindrome(String s) {
    	if(s.length()<2) return true;//s=a ba
        int i=0, j=s.length()-1;//i=0,j=4
        while(i<j){
            if(!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }else if(!Character.isLetterOrDigit(s.charAt(j))){
                    j--;
                }else if(Character.toUpperCase(s.charAt(i))!=Character.toUpperCase(s.charAt(j))){
                return false;
            }else{
                i++;j--;
            }     
        }
        return true;
    }
}