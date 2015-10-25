class Test{
	public static void main(String[] args) {
		int[] c={1,3,5};
		if(args.length>0){
			Solution s=new Solution();			
			int k=Integer.valueOf(args[0]);
			int rst=s.solution(c,k);
			System.out.println("rst="+rst);
		}
	}
}