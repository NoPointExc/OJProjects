import java.util.*;

public class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        int[][] dp=new int[2][len];
        dp[0][0]=Integer.MIN_VALUE;
        dp[1][0]=nums[0];
        for(int i=1;i<len;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);
            dp[1][i]=dp[0][i-1]+nums[i];
        }

        int max=dp[0][len-1];

        dp[0][0]=0;
        dp[1][0]=Integer.MIN_VALUE;

        for(int i=1;i<len;i++){
            dp[0][i]=Math.max(dp[0][i-1],dp[1][i-1]);
            dp[1][i]=dp[0][i-1]+nums[i];
        }

        int tmp=Math.max(dp[0][len-1],dp[1][len-1]);
        max=Math.max(max,tmp);
        return max;
    }
}
