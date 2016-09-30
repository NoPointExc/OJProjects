public class Solution {
    
    public int numSquares(int n) {
    	if( n <= 0){
    		return n;
    	}
    	int[] dp = new int[n+1];

		for(int i=1; i <= n; i++){
			int minSquraeNum = i;
			for(int j=2; j * j <= i; j++){
				minSquraeNum = Math.min(minSquraeNum, i / (j * j) + dp[i % (j * j)]);
			}
			dp[i] = minSquraeNum;
		}

		return dp[n];
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int rst = s.numSquares(13);
    	System.out.println(rst);
    }
}