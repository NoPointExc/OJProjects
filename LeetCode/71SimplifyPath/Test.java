class Test{
	public static void main(String[] args) {
		if(args.length>0){
			Solution s=new Solution();
			String rst=s.simplifyPath(args[0]);
			System.out.println("rst="+rst);
		}
	}
}