import java.util.*;

public class Solution {
    
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        //todo: s ==0
        int minSubArrayLen = Integer.MAX_VALUE;
        int[] leftSum = new int[nums.length + 1];
        leftSum[0] = 0;
        for(int count = 1; count <= nums.length; count++){
            leftSum[count] = nums[count - 1] + leftSum[count - 1];
        }
        
        HashMap<Integer, Integer> leftSumsMap = new HashMap<>();
        for(int count = 0; count <= nums.length; count++){
            if( leftSumsMap.containsKey(leftSum[count] - s) ){
                minSubArrayLen = Math.min(minSubArrayLen,  count - leftSumsMap.get(leftSum[count] - s));
            }
            leftSumsMap.put(leftSum[count], count); 
        }
        
        if(minSubArrayLen == Integer.MAX_VALUE){
            minSubArrayLen = 0;
        }
        return minSubArrayLen;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int s = 6;
        int[] nums = {1,2,3,4,5};
        int rst = sol.minSubArrayLen(s, nums);
        System.out.println(rst);
    }
}