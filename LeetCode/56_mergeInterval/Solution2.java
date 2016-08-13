/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
import java.util.*;

public class Solution2 {
    public List<Interval> merge(List<Interval> intervals) {
        int len=intervals.size();
        List<Interval> rst=new ArrayList<Interval>();
        if(len==0) return rst;
        int[] left=new int[len];
        int[] right=new int[len];

        Iterator<Interval> it=intervals.iterator();
        for(int i=0;i<len;i++){
        	Interval tmp=it.next();
        	left[i]=tmp.start;
        	right[i]=tmp.end;
        }
       	
       	Arrays.sort(left);
        Arrays.sort(right);
        
        int L=left[0];
        int R=right[0];

        for(int i=0;i<len;i++){
        	if(left[i]<=R){
        		R=Math.max(right[i],R);
        	}else{
        		Interval tmp=new Interval(L,R);
        		rst.add(tmp);
        		L=left[i];
        		R=right[i];
        	}
        }

        Interval itr=new Interval(L,R);
        rst.add(itr);
        return rst;
    }
}