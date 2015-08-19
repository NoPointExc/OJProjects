import java.util.*;
class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {-13,10,11,-3,8,11,-4,8,12,-13,5,-6,-4,-2,12,11,7,-7,-3,10,12,13,-3,-2,6,-1,14,7,-13,8,14,-10,-4,10,-6,11,-2,-3,4,-13,0,-14,-3,3,-9,-6,-9,13,-6,3,1,-9,-6,13,-4,-15,-11,-12,7,-9,3,-2,-12,6,-15,-10,2,-2,-6,13,1,9,14,5,-11,-10,14,-5,11,-6,6,-3,-8,-15,-13,-4,7,13,-1,-9,11,-13,-4,-15,9,-4,12,-4,1,-9,-5,9,8,-14,-1,4,14};
		//int[] ans = s.quickSort(nums, 0, nums.length);
		//print(ans);
		//int ans=s.binarySearch(nums,0,nums.length,2);
		List<List<Integer>> ans=s.threeSum(nums);
		System.out.println(ans);
	}


	private static void print(int[] nums) {
		System.out.println("**ANS**");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+",");
		}
		System.out.println();
	}
}