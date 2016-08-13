//{1,3},{2,6},{8,10},{15,18}
import java.util.*;
class Test{
	public static void main(String[] args){
		
		//int[][] arr={{2,3},{4,5},{6,7},{8,9},{1,10}};
		int[][] arr={{1,3},{2,6},{8,10},{15,18}};
		List<Interval> intervals=new ArrayList<Interval> ();
		for(int i=0;i<arr.length;i++){
			Interval tmp=new Interval(arr[i][0],arr[i][1]);
			intervals.add(tmp);
		}
		Solution2 s=new Solution2();
		List<Interval> ans =s.merge(intervals);
		//s.swap(intervals,0,1);
		//s.quickSort(intervals,0,intervals.size());
		for(Interval it:ans){
			System.out.println("{"+it.start+","+it.end+"}");
		}
	}
}
