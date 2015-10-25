class Test{
	public static void main(String[] args) {
		if(args.length>0){
			int[] in=new int[args.length];
			for(int i=0;i<args.length;i++){
				in[i]=Integer.valueOf(args[i]);				
			}
			Solution s=new Solution();
			int rst=s.solution(in);
			System.out.println("rst="+rst);
		}
	}
}