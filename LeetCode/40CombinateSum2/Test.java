import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s =new Solution();
		int[] arr={10,1,2,7,6,1,5};
		List<List<Integer>> ans= s.combinationSum2(arr,8);
		System.out.println(ans);
	}
}