import java.util.*;

class Test{
	public static void main(String[] args) {
		String str="[1,-2,-3,1,3,-2,null,-1]";
		TreeNode root = TreeBuilder.create(str);
		//TreeNode root=null;
		// TreeNode root=new TreeNode(1);
		// TreeNode left=new TreeNode(-2);
		// TreeNode right=new TreeNode(-3);
		// left.left=new TreeNode(1);
		// left.right=new TreeNode(3);
		// right.right=new TreeNode(-2);
		// left.left.left=new TreeNode(-1);
		// root.left=left;
		// root.right=right;
		TreeBuilder.print(root);
		Traveler trv=new Traveler();
		//trv.postorder(root);
		//trv.perorder(root);
		trv.inorder(root);
		//List<List<Integer>>ans=trv.levelorder(root);

	}
}