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
public class Solution{ 
    
    public List<Interval> merge(List<Interval> intervals) {
		int size=intervals.size();
		if(size<=1) return intervals;       
		//quickSort(intervals,0,size);				
		intervals.sort(new Comparator<Interval>(){
				@Override
				public int compare(Interval it1, Interval it2){
					return it1.start-it2.start;
				}
		});


		//merge
		Interval cur=intervals.get(0);
		int start=cur.start, end=cur.end;
		List<Interval> rec=new ArrayList<Interval>();

		    for(int i=1;i<size;i++){
		 		Interval it=intervals.get(i);
		 		//System.out.println("size:"+size+" i:"+i);
		 		//print(intervals);
		 		if(end>=it.start){
		 			end=Integer.max(end,it.end);
		 			//Interval tmp=new Interval(start,end);
		 			//rec.add(tmp);
		 		}else{
		 			Interval tmp=new Interval(start,end);
		 			rec.add(tmp);
		 			start=it.start;
		 			end=it.end;
		 		}
		    }
		    Interval tmp=new Interval(start,end);
		    rec.add(tmp);
		    return rec;
    }


    public void print(List<Interval> intervals){
    	for(Interval it:intervals){
    		System.out.print("["+it.start+","+it.end+"]");
    	}
    	System.out.println();
    }

	public void quickSort(List<Interval> intervals,int h, int t){
		//print(intervals);
		int i=h+1;
		int ref=intervals.get(h).start;		
		for(int j=h+1;j<t;j++){
			//System.out.println(j);	
			if(intervals.get(j).start <	ref){
				swap(intervals,j,i);
				i++;

			}	
		}
		swap(intervals,h,i-1);
		if(i>h+1) quickSort(intervals,h,i);
		if(t>i+1) quickSort(intervals,i,t);
		
	}
	
	public void swap( List<Interval> intervals,int i, int j){

    	Interval itmp=intervals.get(i);
		Interval jtmp=intervals.get(j);
		intervals.remove(i);
		intervals.add(i,jtmp);
		intervals.remove(j);
		intervals.add(j,itmp);
	}
	
}
