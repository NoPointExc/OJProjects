import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		List<List<String>> res= s.solveNQueens(8);
		System.out.println(res.size());
	}
}