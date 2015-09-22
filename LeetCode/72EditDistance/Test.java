class Test{
	public static void main(String[] args) {
		if(args.length>1){
			Solution s=new Solution();
			int rst=s.minDistance(args[0],args[1]);
			System.out.println("rst="+rst);
		}
	}
}