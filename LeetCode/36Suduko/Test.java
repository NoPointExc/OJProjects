class Test{
	public static void main(String[] args) {
		String[] tmp={"....5..1.",".4.3.....",".....3..1","8......2.","..2.7....",".15......",".....2...",".2.9.....","..4......"};
		char[][] suduko=new char[9][9];
		for(int i=0;i<9;i++){

			for(int j=0;j<9;j++){
				suduko[i][j]=tmp[i].charAt(j);
				if(j%3==0) System.out.print("|");
				else System.out.print(" ");
				System.out.print(tmp[i].charAt(j));
			}
			
			System.out.println(" ");
			if((i+1)%3==0) System.out.println("------------------");
		}
		Solution s=new Solution();
		boolean ans=s.isValidSudoku(suduko);
		System.out.println(ans);
	}
}