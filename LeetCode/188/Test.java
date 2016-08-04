class Test{
	public static void main(String[] args) {
		
		Solution s=new Solution();
		int k=2;
		int[] prices={70,4,83,56,94,72}; 
		int rst=s.maxProfit(k,prices);
		System.out.println("rst="+rst);
	}
}