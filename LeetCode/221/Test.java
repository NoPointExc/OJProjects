class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		char[][] matrix={"10100".toCharArray(),"10111".toCharArray(),"11111".toCharArray(),"10010".toCharArray()};
		int rst=s.maximalSquare(matrix);
		System.out.println("rst="+rst);
	}
}