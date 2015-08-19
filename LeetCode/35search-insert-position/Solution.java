import java.util.*;
public class Solution {
    public int searchInsert(int[] nums, int target) {
    	int ans=Arrays.binarySearch(nums,target);
    	if(ans<0){
    		ans=-(ans+1);
    	}
    	return ans;
    }
}