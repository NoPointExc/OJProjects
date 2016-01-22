class Test{
	public static void main(String[] args) {
		int[] preorder={1,2,4,5,8,3,6,7};
		int[] inorder={4,2,8,5,1,6,3,7};
		Solution s=new Solution();
		TreeNode root=s.buildTree(preorder,inorder);
		//s.travel(root);
	}
}