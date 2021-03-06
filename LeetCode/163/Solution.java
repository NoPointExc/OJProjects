import java.util.*;

public class Solution {


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        
        for(int n : nums){
            int justBlow = upper<n-1?upper:n-1;
            if(justBlow==lower) list.add(""+lower);
            else if(justBlow>lower) list.add(lower+"->"+justBlow);
            lower = n+1;
        }
        
        if(upper==lower) list.add(""+lower);
        else if(upper>lower) list.add(lower+"->"+upper);

        return list;
    }


    public static void main(String[] args){
		int[] arr = {0,1,3,50,56,75,100};
		//int[] arr= {-2,-1};
		int low = -2;
		int up = 110;
		List<String> rst = new Solution().findMissingRanges(arr,low,up);
		System.out.println(rst);
    }
}

