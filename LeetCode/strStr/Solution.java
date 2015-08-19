
/**
*Implement strStr().
*Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
*/
public class Solution {
    public int strStr(String haystack, String needle) {// haystack=a, needle=a
    if(needle.length()==0) return 0;
     for(int i=0;i<haystack.length();i++){ //i=1
     	int j=0;
     	int index=i;
     	while(i<haystack.length()&&j<needle.length()&& haystack.charAt(i)==needle.charAt(j) ){
     		j++;i++;
     	}
     	if(j==needle.length()) return index;
     	else {j=0; i=index+1;}
     }
     return -1;   
    }
}