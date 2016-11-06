import java.util.*;
public class Solution {
	HashMap<Integer, Integer> map = new HashMap<>();

    public int combinationSum4(int[] nums, int target) {
        if(nums == null || target <= 0){
        	return 0;
        }
        if(map.containsKey(target)){
        	return map.get(target);
        }
        int count = 0;
        for(int n : nums){
        	if(n < target){
        		count += combinationSum4(nums, target - n);
        	}else if(n == target){
        		count += 1;
        	}
        }
        map.put(target, count);
        return count;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	System.out.println(sol.combinationSum4(new int[]{1,2,3}, 4));
    }
}