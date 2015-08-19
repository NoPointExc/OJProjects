class Test{
	public static void main(String[] args) {
		char[ ] [ ] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}; 
		
		Solution s=new Solution();
		int ans=s.numIslands(grid);
		System.out.println("ANS="+ans);
	}
}