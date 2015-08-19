public class Solution {
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
        	int j=0;
        	for(;j<needle.length()&& haystack.charAt(i)==needle.charAt(j);j++) i++;
        	i=i-j;
        	if(j==needle.length()) return i;
        }
        return -1;
    }
}