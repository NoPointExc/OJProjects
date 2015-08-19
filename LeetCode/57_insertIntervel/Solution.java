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
public class Solution {


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	List<Interval> ans=new ArrayList<Interval> ();    	
    	for(Interval it:intervals){
    		if(ans.size()==0 && newInterval.end< it.start) ans.add(newInterval); 
    		if( ans.size()>0 && newInterval.start>ans.get(ans.size()-1).end && newInterval.end< it.start ){
    			ans.add(newInterval);
    		}
    		if(it.end<newInterval.start || it.start>newInterval.end ){
    			ans.add(it);
    		}else{
    			newInterval.start=newInterval.start<it.start?newInterval.start:it.start;
    			newInterval.end=newInterval.end>it.end?newInterval.end:it.end;
    		}	   		
    	}
    	if(ans.size()==0) ans.add(newInterval); 
		else if( ans.size()>0 && newInterval.start>ans.get(ans.size()-1).end )
			ans.add(newInterval);
		return ans;
	}	
}
