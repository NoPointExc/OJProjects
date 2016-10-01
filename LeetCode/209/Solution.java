public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0 || s == 0){
            return 0;
        }
        
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        boolean isFound = false;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            
            while(sum >= s && left <= right){
                minLen = Math.min(minLen, right - left + 1);
                isFound = true;
                sum -= nums[left];
                left++;
            }
        }
        
        if(!isFound){
            minLen = 0;
        }
        
        return minLen;
    }
}