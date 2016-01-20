class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
		//root.right=new TreeNode(1);
		 s.recoverTree(root);
		System.out.println(root.val+""+root.left.val+"");
	}
}