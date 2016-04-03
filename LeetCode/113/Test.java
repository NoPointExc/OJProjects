import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		TreeNode root=new TreeNode(1);
		TreeNode cur=root;
		cur.left=new TreeNode(2);
		cur.right=new TreeNode(3);
		cur=cur.left;
		cur.right=new TreeNode(4);
		List<List<Integer>> ans=s.pathSum(root,1);
		//System.out.println(ans);
	}
}

          //   1
          // 2     3
          //   4