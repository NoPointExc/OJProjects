
class Solution {
	public int minCut(String s) {
		int len=s.length();
		int i=-1;
		boolean isValidL=false, isValidR=false;

		while(i<len && !isValidL && !isValidR ){
			i++;
			isValidL=isPalindrome(s.substring(0,len-i));
			isValidR=isPalindrome(s.substring(i,len));
		}

		if(i==0) return 0;
		int min=len-1
		if(isValidL){
			min=1+minCut(s.substring(len-i,len));
		}

		if(isValidR){
			int tmp=1+minCut(s.substring(0,i));
			min=min<tmp?min:tmp;
		}

		return min;

	}

	private boolean isPalindrome(String str){
		int len=str.length();
		for(int i=0;i<(len-i-1);i++){
			if( str.charAt(i)!=str.charAt(len-i-1) ) return false;
		}
		return true;
	}
}
