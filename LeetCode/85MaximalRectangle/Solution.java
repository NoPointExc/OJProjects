import java.util.*;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
        int rLen=matrix.length;
        int cLen=matrix[0].length;
        int[] h=new int[cLen];
        int maxA=0;
        for(int row=0;row<rLen;row++){
            //count h[]
            for(int col=0;col<cLen;col++){
                if(row==0) h[col]=0;
                // 0 =0, '1' +1
                if(matrix[row][col]=='1') h[col]++;
                else h[col]=0;                
            }
            //cal max area
            int curA=largestRectangleArea(h);
            maxA=curA>maxA?curA:maxA;
        }

        return maxA;
    }

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