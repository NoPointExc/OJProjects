class Test{
	public static void main(String[] args) {
		if(args.length>0){
			int n=Integer.valueOf(args[0]);
			Solution s=new Solution();
			int rst=s.climbStairs(n);
			System.out.println("rst="+rst);
		}
	}
}