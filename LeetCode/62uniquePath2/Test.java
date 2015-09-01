class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[][] in=new int[9][8];
		for(int i=0;i<in[0].length;i++){
			for(int j=0;j<in.length;j++){
				//System.out.println("i="+i+"j="+j);
				in[j][i]=0;
			}
		}
		int ans=s.uniquePathsWithObstacles(in);
		System.out.println("ans="+ans);
	}
}