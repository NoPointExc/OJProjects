import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		List<TreeNode> ans=s.generateTrees(Integer.valueOf(args[0]));
		System.out.println("ans="+ans);
	}
}