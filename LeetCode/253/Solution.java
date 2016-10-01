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
    public int minMeetingRooms(Interval[] intervals) {        
        if(intervals == null){
            return 0;
        }
        
        int minMeetingRoom = 0;
        StartComparator startComparator = new StartComparator();
        Arrays.sort(intervals, startComparator);  
        EndComparator endComparator = new EndComparator();
        PriorityQueue<Interval> roomQueue = new PriorityQueue<>(endComparator);
        
        for(int i=0; i < intervals.length; i++){
            if(intervals[i] == null){
                continue;
            }                       
            //release empty room
            while(!roomQueue.isEmpty() && roomQueue.peek().end <= intervals[i].start){
                   roomQueue.poll();
            }
            //reserve room
            roomQueue.offer(intervals[i]);
            minMeetingRoom = Math.max(minMeetingRoom, roomQueue.size());           
        }
        
        return minMeetingRoom;
    }
    
    class StartComparator implements Comparator<Interval>{     
        public int compare(Interval interval1, Interval interval2){
            int start1 = interval1 == null ? 0:interval1.start;
            int start2 = interval2 == null ? 0:interval2.start;
            return start1 - start2;
        }
    }
    
    class EndComparator implements Comparator<Interval>{     
        public int compare(Interval interval1, Interval interval2){
            int end1 = interval1 == null ? 0:interval1.end;
            int end2 = interval2 == null ? 0:interval2.end;
            return  end1 - end2;
        }
    }
}