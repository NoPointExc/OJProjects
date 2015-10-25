class Test{

	public static void main(String[] args) {
		if(args.length>1){
			int[] steps=new int[args.length];
			for(int i=0;i<args.length;i++) steps[i]=Integer.valueOf(args[i]);
			Solution s=new Solution();
			int rst=s.solution(steps,85,10000000);
			System.out.println(rst);
		}
	}
}