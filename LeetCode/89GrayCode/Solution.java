import java.util.*;
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> fwd=new ArrayList<Integer>();
        ArrayList<Integer> rev;
        fwd.add(0);
        if(n==0) return fwd;
        fwd.add(1);
        for(int i=2;i<=n;i++){
        	rev=new ArrayList<Integer>();
        	for(int j=fwd.size()-1;j>=0;j--)
        		rev.add(fwd.get(j)+(int)Math.pow(2,i-1));     	
        	fwd.addAll(rev);
        }
        return fwd;
    }
}