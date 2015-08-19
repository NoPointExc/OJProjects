import java.util.*;
public class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map=new HashMap<>();
        while(!map.containsKey(n)){
        	if(n==1) return true;
        	map.put(n,true); //k,v
        	int tmp=0;
        	while(n!=0){	
        		tmp+=(n%10;)*(n%10;);
        		n/=10;
        	}
        	n=tmp;
        }
        return false;
    }
}