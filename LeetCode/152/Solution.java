public class Solution {
    public int maxProduct(int[] nums) {
    	int len=nums.length;
    	if(len==1) return nums[0];
    	int max=nums[0];
    	int min=nums[0];
    	int rst=max;
    	for(int i=1;i<len;i++) {
    		if(nums[i]>0){
    		    max=Math.max(max*nums[i],nums[i]);
    		    min=Math.min(min*nums[i],nums[i]);
    		}else{
    		    int lastMax = max;
    		    max=Math.max(min*nums[i],nums[i]);
    		    min=Math.min(lastMax*nums[i],nums[i]);
    		}
    		
    		rst=Math.max(rst,max);
    	}
    	
    	return rst;
    }
}