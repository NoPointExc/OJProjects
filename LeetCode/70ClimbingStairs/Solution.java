import java.util.*;
public class Solution {
	Map<Integer, Integer> map=new HashMap<Integer,Integer>();
    public int climbStairs(int n) {
   		if(n==1) return 1;
   		if(n==2) return 2;
   		int rst=0;
   		if(map.get(n)!=null) {
   			rst=map.get(n);
   		}else{
   			rst=climbStairs(n-1)+climbStairs(n-2);
   			map.put(n,rst);
   		}
   		return   rst;    
    }
}