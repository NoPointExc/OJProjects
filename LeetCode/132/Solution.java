import java.util.*;

class Solution {
	//private HashMap<String,Boolean> map=new HashMap();
	char[] str;
	public int minCut(String s) {
		if(s==null) return 0;
		int len=s.length();
		str=s.toCharArray();
		if(len<=1 || isPalindrome(0,len)) return 0;
		int[] cuts=new int[len];
		Arrays.fill(cuts,len-1);
		
		for(int i=len-1;i>=0;i--){
			if(isPalindrome(i,len)){
				cuts[i]=0;
			}else{
				for(int j=i+1;j<len;j++){
					if(cuts[j]+1<cuts[i] && isPalindrome(i,j))
						cuts[i]=1+cuts[j];
				}
			}
		}

		return cuts[0];	
	}

	private boolean isPalindrome(int from, int to){
		//if(map.containsKey(str)) return map.get(str);
		for(int i=0;(from+i)<(to-i-1);i++){
			if( str[from+i]!=str[to-i-1] ) {
				//map.put(str,false);
				return false;
			}
		}
		//map.put(str,true);
		return true;
	}
}
