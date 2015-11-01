class Test{
	public static void main(String[] args) {
		if(args.length>0){
			char [][] matrix=new char[args.length][args[0].length()];
			for(int i=0;i<matrix.length;i++){
				matrix[i]=args[i].toCharArray();
			}
			Solution s=new Solution();
			int rst=s.maximalRectangle(matrix);
			System.out.println("rst="+rst);
		}
		//System.out.println('1'+0);
	}
}