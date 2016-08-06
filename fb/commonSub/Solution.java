/**
 * two string, such as "leetcode","codyabc" and a int k=3.
 * ASK: whether you can found a common substirng which length>=k. such as "cod" in example >=3 
 */
class Solution{

	public boolean commonSub(String s1,String s2,int k){
		int len=s1.length();
		int wid=s2.length();
		if(k>len || k>wid) return false;
		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();

		int[][] dp=new int[wid][len];
		
		for(int i=1;i<wid;i++){
			for(int j=1;j<len;j++){
				if(arr2[i]==arr1[j]){
					dp[i][j]=dp[i-1][j-1]+1;
				}else{
					dp[i][j]=0;
				}
				if(dp[i][j]>=k) return true;
			}
		}

		return false;
	}
}