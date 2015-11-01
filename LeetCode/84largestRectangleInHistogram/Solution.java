
import java.util.*;
public class Solution {
	
    public int largestRectangleArea(int[] height) {    
    	Stack <Integer> index =new Stack<Integer> ();
    	int curA=0;
    	int maxA=0;
    	int top=0;
    	if(height.length==0) return maxA;
    	for(int i=0;i<=height.length;i++){
			while(!index.isEmpty() && (i==height.length|| height[i]<height[index.peek()])){
				top = index.pop();
             	curA = height[top]*(index.isEmpty()? i: i-index.peek()-1);
             	maxA = Math.max(curA, maxA);
			}
    		index.push(i);
    	}

    	return maxA;
    }

    
}