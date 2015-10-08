import java.util.*;
public class Solution {
    public boolean search(int[] nums, int target) {
        int h=0, t=nums.length-1;
        int mid=-1;  
        while(h<t && nums[h]==nums[t]) h++;  
        int start=h;   
        while(mid!=(h+t)/2){
        	while(h<t && nums[h]==nums[t]) h++;	
        	mid=(h+t)/2;
        	if(nums[mid]<nums[h])t=mid;
        	else h=mid;
        }
        int index=Arrays.binarySearch(nums,start,t,target);
        if(index>=0) return true;
        index=Arrays.binarySearch(nums,t,nums.length,target);
        if(index>=0) return true;
        return false;
    }
}