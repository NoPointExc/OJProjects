import java.util.*;
class Test{
	public static void main(String[] args) {
		int[] nums={-3,-1,0,2,4,5}; 
		Solution s=new Solution();
		List<List<Integer>> ans=s.fourSum(nums,2);
		System.out.println("ANS:"+ans);
	}
}