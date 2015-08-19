public class Solution {
	public int maxArea(int[] height) {
		int max = 0, i = 0, j = height.length - 1;
		max=Math.min(height[i],height[j])*(j-i);
		while(i<j){
			int h=height[j];
			if(height[i]<height[j]){
				h=height[i]; //h=1
				i++;
				while(i<j && height[i]<=h) i++;							
			}else{
				j--;
				while(i<j && height[j]<=h) j--;
			}
			h=Math.min(height[i], height[j]);
			max=Math.max(h*(j-i), max);
		}		
		return max;
	}
}