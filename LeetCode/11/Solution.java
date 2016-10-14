public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        
        while(left < right){
            int depth = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, (right - left) * depth);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        
        return maxArea;
    }
}