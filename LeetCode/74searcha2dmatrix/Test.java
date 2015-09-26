public class Test{
	public static void main(String[] args) {
		if(args.length!=0){
			Solution s=new Solution();
			int[][] in=new int[9][9];
			for(int i=0;i<in.length;i++){
				for(int j=0;j<in[0].length;j++){
					in[i][j]=2*((i)*in.length+j);
					System.out.print(in[i][j]+",");
				}
				System.out.println();
			}

			boolean rst=s.searchMatrix(in,Integer.valueOf(args[0]));
			System.out.println("rst="+rst);
		}
	}
}