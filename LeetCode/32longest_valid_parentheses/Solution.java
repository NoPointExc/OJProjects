import java.util.*;
public class Solution {
    public int longestValidParentheses(String s) {
		LinkedList<Integer> lens=new LinkedList<Integer>();
		int curLen=0,max=0,len=s.length();
		for(int i=0;i<len;i++){
			if(s.charAt(i)=='('){
				lens.push(curLen);
				curLen=0;
			}else{
				if(!lens.isEmpty()){
					curLen=curLen+lens.pop()+2;
					if(curLen>max) max=curLen;
				}else curLen=0;
			}
			// System.out.print("i:"+i);
			// System.out.print("  lens:"+lens);
			// System.out.print("  curLen:"+curLen);
			// System.out.println("  max:"+max);
		}
		return max;   
    }
}