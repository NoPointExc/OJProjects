public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
	if(nums.length==0 || k<=0)
	    return new int[0];
	
	int[] leftMax = new int[nums.length];
	int[] rightMax = new int[nums.length];
	int[] rst = new int[nums.length-k+1];
	for(int i=0;i<nums.length;i++){
		if(i%k==0 || leftMax[i-1]<nums[i])
		    leftMax[i] = nums[i];
		else 
		    leftMax[i] = leftMax[i-1];
	}

	for(int i=nums.length-1;i>=0;i--){
	    if((nums.length-1-i)%k==0 || rightMax[i+1]<nums[i])
		rightMax[i] = nums[i];
	    else 
		rightMax[i] = rightMax[i+1];
	}


	for(int i=0;i<rst.length;i++){
	    rst[i] = rightMax[i]>leftMax[i+k-1]? rightMax[i]:leftMax[i+k-1];
	}

    	return rst;
    }
}

