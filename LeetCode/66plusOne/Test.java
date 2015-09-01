class Test{
	public static void main(String[] args) {
		int[] in;
		if(args.length>0){
			Solution s=new Solution();
			char[] tmp=args[0].toCharArray();
			in=new int[tmp.length];
			for(int i=0;i<tmp.length;i++){
				in[i]=tmp[i]-48;
			}
			int[] ans=s.plusOne(in);
			StringBuilder sb=new StringBuilder();
			for(int n:ans) sb.append(n);
			System.out.println(sb.toString());
		}
	}
}