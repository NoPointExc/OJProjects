import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		TreeNode tree=new TreeNode(1);
		tree.left=new TreeNode(2);
		tree.right=new TreeNode(3);
		List<Integer> ans=s.inorderTraversal(tree);
		System.out.println(ans);
	}
}