class Test{
	public static void main(String[] args) {
		if(args.length>0){
		
			char[][] board={"ABCE".toCharArray(),"SFES".toCharArray(),"ADEE".toCharArray()};
			Solution s=new Solution();
			boolean rst=s.exist(board,args[0]);
			System.out.println("rst:"+rst);
		}

	}
}