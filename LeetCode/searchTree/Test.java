class Test{
	public static void main(String[] args) {
		TreeNode root=new TreeNode(5);
		root.left =new TreeNode(2);
		root.right =new TreeNode(10);
		root.left.right =new TreeNode(3);
		Solution s= new Solution();
		s.travel(root);
	}
}