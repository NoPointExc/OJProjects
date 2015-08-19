public class Solution {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int h=0, t=len-1,mid=-1;
        while(mid!=(h+t)/2){
        	mid=(h+t)/2;
        	if(nums[mid]>=nums[h]){
        		if(target>=nums[h]&&target<=nums[mid])  t=mid;
        		else h=mid;       		
        	}else{
        		if(target<=nums[t] && target>nums[mid]) h=mid;
        		else t=mid;
        	}        
        }
        if(nums[t]==target) return t;
        return -1;
    }
}