class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		for(String arg:args){
			int ans=s.romanToInt(arg);
			System.out.println("in="+arg+" ,out="+ans);
		}
	}
}