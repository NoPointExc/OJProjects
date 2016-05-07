class Test{
	public static void main(String[] args){
		Solution s=new Solution();
		TreeBuilder builder=new TreeBuilder();
		TreeNode root=builder.create("[-1,-2,-3]");
		builder.print(root);
		int rst=s.maxPathSum(root);
		System.out.println(rst);
	}

}
