import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }        
        IntervalComparator comparator = new IntervalComparator();
        Arrays.sort(intervals, comparator);
        
        for(int i=0; i < intervals.length -1; i++){
            if(intervals[i].end > intervals[i + 1].start){
                return false;
            }    
        }
        
        return true;
        
    }
    
    class IntervalComparator implements Comparator<Interval>{
        
        public int compare(Interval interval1, Interval interval2){
            return interval1.start - interval2.start;    
        }
        
    }
}