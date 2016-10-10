public class Solution {
    
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }    
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length && nums[k] + nums[i] + nums[j] < target; k++){
                    //if(k -1 == j || nums[k] != nums[k - 1]){
                        count++;
                    //}
                }
            }
        }
        
        return count;
    }
}