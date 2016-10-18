public class Solution {
    public int getMoneyAmount(int n) {
        if(n <= 1){
            return 0;
        }
        
        int[][] dp = new int[n][n];
    
        for(int len = 2; len <= n; len++){
            // start = 0, end = 0 + 3 -1 = 2; len = 3; mid = 1; 
            for(int start = 0, end = start + len - 1; end < n; start++, end = start + len -1){
                if(len == 2){
                    dp[start][end] = start + 1;
                }else{
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int mid = start + 1; mid < end; mid++){
                        //start[0][2] = min()
                        dp[start][end] = Math.min(dp[start][end], (mid + 1) + Math.max(dp[start][mid - 1] , dp[mid + 1][end]));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}