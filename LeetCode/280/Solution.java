public class Solution {
    
    public void wiggleSort(int[] nums) {
        if(nums == null){
            return;
        }
        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 0){
                if(nums[i] > nums[i - 1]){
                    swap(i, i - 1, nums);
                }
            }else{
                if(nums[i] < nums[i -1]){
                    swap(i, i -1, nums);
                }
            }
        }
    }
    
    private void swap(int i, int j, int[] nums){    
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}