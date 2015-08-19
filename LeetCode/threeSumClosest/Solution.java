import java.util.*;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len=nums.length; int closest;
        if(len<3) return 0;
        closest=nums[0]+nums[1]+nums[2];
        //sort
        Arrays.sort(nums);
        //search, i=0~n ,j=head, i+1~k , k=tail, k<n, 
        for(int i=0;i<len;i++){
        	int j=i+1, k=len-1;
        	while(j<k){
        		int threeSum=nums[i]+nums[j]+nums[k];
        		if(threeSum>target){
        			closest=(threeSum-target<Math.abs(closest-target))?threeSum:closest;
        			k--;
        		}else if(threeSum<target){
        			closest=(target-threeSum<Math.abs(closest-target))?threeSum:closest;
        			j++;
        		}else return target;
        	}
        }

        return closest;

    }
}