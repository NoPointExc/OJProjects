//{1,3},{2,6},{8,10},{15,18}
import java.util.*;
class Test{
	public static void main(String[] args){
		
		int[][] arr={{2,4},{6,7},{8,9},{11,20},{50,60}};

		List<Interval> intervals=new ArrayList<Interval> ();
		for(int i=0;i<arr.length;i++){
			Interval tmp=new Interval(arr[i][0],arr[i][1]);
			intervals.add(tmp);
		}
		Interval newIt=new Interval(3,70);
		Solution s=new Solution();
		List<Interval> ans =s.insert(intervals,newIt);
		
		for(Interval it:ans){
			System.out.println(it);
		}
	}
}