class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		TreeNode root=new TreeNode(4);
		root.left=new TreeNode(7);
		root.right=new TreeNode(2);
		root.left.left=new TreeNode(1);
		root.left.right=new TreeNode(3);
		s.invertTree(root);
		System.out.println(root.val);
		System.out.println(root.left.val+"  "+root.right.val);
		System.out.println(root.left.left.val+"  "+root.left.right.val);
	}
}