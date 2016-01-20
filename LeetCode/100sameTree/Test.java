class Test{
	public static void main(String[] args) {
		TreeNode t1=new TreeNode(0);
		t1.left=new TreeNode(1);
		t1.right=new TreeNode(2);
		TreeNode t2=new TreeNode(0);
		t2.left=new TreeNode(1);
		t2.right=new TreeNode(2);
		TreeNode t3=t1;
		Solution s=new Solution();
		boolean ans=s.isSameTree(t1,t2);
		System.out.println(ans);
	}
}