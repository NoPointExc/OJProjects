import java.util.*;
public class Solution {
    public int numTrees(int n) {
      if(n==0) return 0;
      ArrayList<Integer> nums=new ArrayList<Integer>();
      nums.add(1);
      for(int i=1;i<=n;i++){
      	int num=0;
      	for(int j=0;j<i;j++){
      		num+=nums.get(i-j-1)*nums.get(j);      			
      	}
      	nums.add(num);
      }
      return nums.get(n);  
    }
}