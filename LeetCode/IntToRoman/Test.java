class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		for(String in:args){
			int num=Integer.valueOf(in);
			String ans=s.intToRoman(num);
			System.out.println(in+": "+ans);
		}
	}
}