public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        
        int traped = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int l = 1, r = height.length - l -1; l < height.length; l++, r--){
            leftMax[l] = Math.max(height[l], leftMax[l - 1]);
            rightMax[r] = Math.max(height[r], rightMax[r + 1]);
        }
        
        for(int i = 0; i < height.length; i++){
            traped += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        
        return traped;
    }
}