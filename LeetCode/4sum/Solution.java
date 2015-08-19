import java.util.*;
public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Set<List<Integer>> set = new HashSet<>();
		Arrays.sort(nums);
		int len = nums.length;
		if (len < 4) return ans;
		for (int h0 = 0; h0 < len; h0++) {
			for (int t0 = len - 1; t0 > h0+1; t0--) {
				for (int h1 = h0 + 1, t1 = t0 - 1; h1 < t1;) {				
					int sum = nums[h0] + nums[h1] + nums[t0] + nums[t1];
					//System.out.println("h0="+h0+" ,h1="+h1+" ,t1="+t1+" ,t0="+t0+" ,sum="+sum);
					if (sum == target ) {
						List<Integer> tmp = new ArrayList<Integer>();
						tmp.add(nums[h0]);
						tmp.add(nums[h1]);
						tmp.add(nums[t1]);
						tmp.add(nums[t0]);
						if (set.add(tmp)) ans.add(tmp);
						h1++; t1--;
					} else if (sum > target) t1--;
					else h1++;
				}
			}			
		}
		return ans;
	}
}