public class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb1=new StringBuilder(Integer.toString(x));
        StringBuilder sb2=new StringBuilder(Integer.toString(x));
        return sb1.toString().equals(sb2.reverse().toString());
    }
}