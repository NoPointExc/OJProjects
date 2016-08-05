public class Solution {
    public int maximalSquare(char[][] matrix) {
        int wid=matrix.length;
        if(wid==0) return 0;
        int len=matrix[0].length;
        int[][] dp=new int[wid][len];
        int max=0;
        
        for(int i=0;i<wid;i++){
            for(int j=0;j<len;j++){
                if(matrix[i][j]=='1'){
                    if(i==0 || j==0) dp[i][j]=1;
                    else{
                        int tmp=Math.min(dp[i-1][j],dp[i][j-1]);
                        tmp=Math.min(tmp,dp[i-1][j-1]);
                        dp[i][j]=tmp+1;
                    }
                }else{
                    dp[i][j]=0;
                }
                if(dp[i][j]>max) max=dp[i][j];
            }
        }
        return max*max;
    }
}