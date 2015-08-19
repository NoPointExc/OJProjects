public class Solution {
    public int maxSubArray(int[] nums) {
    	int max=Integer.MIN_VALUE, curMax=0;
    	for(int cur:nums){
    		curMax=curMax>0?curMax+cur:cur;
    		max=curMax>max?curMax:max;
    	}
    	return max;
    }
}