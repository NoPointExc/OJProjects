public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null){
            return;
        }
        Arrays.sort(nums);
        int[] tmp = new int[nums.length];
        int j = nums.length - 1;

        for(int i = 1; i < nums.length; i += 2, j--){
            tmp[i] = nums[j]; 
        }
        
        for(int i = 0; i < nums.length; i += 2, j--){
            tmp[i] = nums[j]; 
        }
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = tmp[i];
        }
        
    }
    
}