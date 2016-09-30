import java.util.*;

public class Solution {
    
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums == null){
            return -1;
        }
        if(nums.length == 0){
            return k == 0?0:-1; 
        }
        
        int maxSubLen = 0;
        int[] subSum = new int[nums.length + 1]; //?? len+1?
        //min subArr len map
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i = 1; i <= nums.length; i++ ){
            subSum[i] = subSum[i-1] + nums[i - 1];
            if(!map.containsKey(subSum[i])){
                map.put(subSum[i], i);
            }
        }
        

        for(int count=1; count <= nums.length; count++){                  
            //if exist subSum[count] - subSum[?] == k, then len =count - ?
            if(map.containsKey(subSum[count] - k)){
                maxSubLen = Math.max(count - map.get(subSum[count] - k), maxSubLen);
            }
            

        }
        
        return maxSubLen;
    }
    
}