class Test{
	public static void main(String[] args) {
		int[][] matrix=new int[4][4];
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				matrix[i][j]=(i+1)*10+j+1;
			}
		}
		Solution s=new Solution();
		s.rotate(matrix);
	}
}