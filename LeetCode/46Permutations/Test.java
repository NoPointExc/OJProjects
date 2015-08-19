import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] arr={7,8,9};
		List<List<Integer>> ans=s.permute(arr);
		System.out.println(ans);
	}
}