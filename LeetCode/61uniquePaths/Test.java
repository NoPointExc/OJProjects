class Test{
	public static void main(String[] args) {
		if(args.length==2){
			int m=Integer.valueOf(args[0]);
			int n=Integer.valueOf(args[1]);
			Solution s=new Solution();
			int ans=s.uniquePaths(m,n);
			System.out.println("ans="+ans);
		}
	}
}