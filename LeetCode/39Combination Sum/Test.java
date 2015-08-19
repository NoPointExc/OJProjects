import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s =new Solution();
		int[] arr={8,7,4,3};
		List<List<Integer>> ans= s.combinationSum(arr,11);
		System.out.println(ans);
	}
}