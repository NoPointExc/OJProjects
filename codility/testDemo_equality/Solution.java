// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        int rst=-1;
        //if(A.length==0) return 0;
        long sum=0;
        for(int i=0;i<A.length;i++){
        	//System.out.println(A[i]+"sum="+sum);
        	sum+=A[i];
        }

        long cur=0;
        for(int i=0;i<A.length;i++){        	
        	if(cur==(sum-cur-A[i])) return i;
        	cur+=A[i];
        	//System.out.println("cur="+cur+"sum-cur="+(sum-cur));
        	
        }
        return rst;
    }
}