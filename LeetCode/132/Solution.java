import java.util.*;

class Solution {
	private HashMap<String,Boolean> map=new HashMap();

	public int minCut(String s) {
		if(s==null) return 0;
		int len=s.length();
		if(len<=1 || isPalindrome(s)) return 0;
		int[] cuts=new int[len];
		Arrays.fill(cuts,len-1);
		
		for(int i=len-1;i>=0;i--){
			if(isPalindrome(s.substring(i))){
				cuts[i]=0;
			}else{
				for(int j=i+1;j<len;j++){
					if(cuts[j]+1<cuts[i] && isPalindrome(s.substring(i,j)))
						cuts[i]=1+cuts[j];
				}
			}
		}

		return cuts[0];	
	}

	private boolean isPalindrome(String str){
		if(map.containsKey(str)) return map.get(str);
		int len=str.length();
		for(int i=0;i<(len-i-1);i++){
			if( str.charAt(i)!=str.charAt(len-i-1) ) {
				map.put(str,false);
				return false;
			}
		}
		map.put(str,true);
		return true;
	}
}
