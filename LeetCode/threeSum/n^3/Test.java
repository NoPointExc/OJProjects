import java.util.*;
class Test{
	public static void main(String[] args) {
		int[] nums={1,-1,0,2,3,4};
		Solution s=new Solution();
		List<List<Integer>> ans=s.threeSum(nums);
		//boolean ans=s.search(-1,0,3,nums);
		System.out.println(ans);
	}
}