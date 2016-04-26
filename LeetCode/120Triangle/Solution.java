import java.util.*;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return 0;
      
        ListIterator<List<Integer>> it=triangle.listIterator(triangle.size());
        List<Integer> bt=triangle.get(),tp=null;
        
        while(it.hasPrevious()){
            if(tp!=null) bt=tp;
            else bt=it.previous();
        	if(it.hasPrevious()){
        		tp=it.previous();
        		int len=tp.size();
        		for(int i=0;i<len;i++){
        			int val=tp.get(i);
        			int lv=bt.get(i);
        			int rv=bt.get(i+1);
        			int min=lv<rv?lv:rv;
        			tp.set(i,min);
        		}	
        	}        	        	
        }
        return triangle.get(0).get(0);
    }
}