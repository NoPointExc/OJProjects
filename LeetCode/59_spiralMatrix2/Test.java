class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[][] matr=s.generateMatrix(5);
		for(int i=0;i<matr[0].length;i++){
			for(int j=0;j<matr.length;j++){
				System.out.print(matr[i][j]+"   ");
			}
			System.out.println();
		}
	}
}