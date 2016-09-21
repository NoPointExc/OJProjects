import java.util.*;

public class Solution {


    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        for(int n : nums){
            int justBelow = n - 1;
            if(justBelow>upper) break;
            if(lower == justBelow) list.add(lower+"");
            else if(lower < justBelow) list.add(lower + "->" + justBelow);
            lower = n+1;
        }
        if(lower == upper) list.add(lower+"");
        else if(lower < upper) list.add(lower + "->" + upper);
        return list;
    }


    public static void main(String[] args){
		int[] arr = {0,1,3,50,56,75};
		//int[] arr= {-2,-1};
		int low = -2;
		int up = 55;
		List<String> rst = new Solution().findMissingRanges(arr,low,up);
		System.out.println(rst);
    }
}

