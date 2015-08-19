class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		
		int[][] matr=MatGen.generat();
		System.out.println("******ans**********");
		System.out.println("*******************");
		MatGen.print(matr);
		matr=MatGen.remove(60,matr);
		char[][] board=new char[9][9];
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(matr[i][j]==0)  board[i][j]='.';
				else board[i][j]=(char)(matr[i][j]+48);
			}
		}
		System.out.println("******problem******");
		System.out.println("*******************");
		MatGen.print(board);
		s.solveSudoku(board);
		System.out.println("******solve********");
		System.out.println("*******************");
		MatGen.print(board);
	}
}