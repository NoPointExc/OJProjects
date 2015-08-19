 public class Solution {
    public boolean canJump(int[] nums) {
    	int max=0;
    	for(int i=0;i<nums.length-1;i++){
    		if(nums[i]!=0){
    			max=nums[i]+i>max?nums[i]+i : max;
    		}else{
    			if(max>i) continue;
    			else return false;
    		}
    	}
    	return true;
    }
}