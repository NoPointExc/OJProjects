import java.util.*;

public class Solution {

    public int countNumbersWithUniqueDigits(int n) {
	if(n<0)
	    return 0;
	int rst = 0;
	n = n>10?10:n;
	int[] unique = new int[n+1];
	Arrays.fill(unique,1);

	for(int i=1;i<=n;i++){
	    for(int j=0;j<i;j++){
		unique[i] = unique[i-1]*(j==0?9:10-j);	
	    }
	}

	for(int i=0;i<=n;i++){
	    rst += unique[i];
	}

	return rst;
    }

    public static void main(String[] args){
	Solution s = new Solution();
	for(int i = -2;i<20;i++){
	    int rst = s.countNumbersWithUniqueDigits(i);
	    System.out.println("i="+i+" rst="+rst);
	}
    }

}

