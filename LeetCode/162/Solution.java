public class Solution {
    
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0, right = nums.length;
        
        while(left < right - 1){
            int mid = (left + right) / 2;
            if(nums[mid - 1] < nums[mid]){
                left = mid; 
            }else{
                right = mid;
            }
        }
        
        return (left + right) / 2;
    }
}