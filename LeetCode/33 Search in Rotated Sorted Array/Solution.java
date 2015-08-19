import java.util.*;
public class Solution {
	
	//2st Solution
	public int search(int[] nums, int target) {
		int len=nums.length;
		if(len==0) return -1;
		int h=0,t=len-1,mid=-1;
		while(mid!=(h+t)/2){
			mid=(h+t)/2;
			if(nums[mid]<nums[h]) t=mid;
			else h=mid;
		}
		int index=Arrays.binarySearch(nums,0,t,target);
		if(index>=0) return index;
		index=Arrays.binarySearch(nums,t,len,target);
		if(index>=0) return index; 
		return -1;
	}


}
 