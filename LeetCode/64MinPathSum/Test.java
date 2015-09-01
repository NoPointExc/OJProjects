class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[][] in=new int[2][2];
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<in[0].length;i++){
			for(int j=0;j<in.length;j++){
				in[j][i]=1;
				//sb.append(1);
			}
			//sb.append("\n");
		}
		in[0][1]=2;
		//System.out.println(sb.toString());
		int ans=s.minPathSum(in);
		System.out.println("ans="+ans);
	}
}