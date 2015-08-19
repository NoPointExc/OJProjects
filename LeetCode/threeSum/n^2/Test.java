import java.util.*;
class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] num = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		List<List<Integer>> ans = s.threeSum(num);
		System.out.println(ans);
	}
}