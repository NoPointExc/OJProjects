public class Solution {
    public int trap(int[] height) {
    	int water=0;
    	if(height.length<2) return water;
        int leftMax=0;
        int rightMax=getMax(height,1); 
        for(int i=0;i<height.length-1;i++){      
      		int h=height[leftMax]<height[rightMax]?height[leftMax]:height[rightMax];
      		if(h-height[i]>0) water+= h-height[i];
      		if(height[leftMax]<height[i+1]) leftMax=i+1;
      		if(rightMax==i) rightMax=getMax(height,i+1);
      	}
      	return water;
    }
    private int getMax(int[] arr, int start){
    	if(arr.length-1==start) return start;
    	int maxIndex=start;
    	for(int i=start;i<arr.length;i++) maxIndex=arr[maxIndex]<arr[i]? i: maxIndex; 
    	return maxIndex;
    }
}