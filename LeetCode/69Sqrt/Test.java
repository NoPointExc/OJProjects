class Test{
	public static void main(String[] args) {
		if(args.length>0){
			int x=Integer.valueOf(args[0]);
			Solution s=new Solution();
			int rst=s.mySqrt(x);
			System.out.println("rst="+rst);
		}
	}
}