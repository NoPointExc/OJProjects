public class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums,0);
    }
    public boolean canJump(int[] nums, int start){
        if(start>=nums.length) return true;
        for(int i=nums[start];i>0;i--){
            if(canJump(nums,i+start)) return true;
        }
        return false;
    }
}