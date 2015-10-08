class Test{
	public static void main(String[] args) {
		int [] arr={0,2,2};
		if(args.length>0){
			int target=Integer.valueOf(args[0]);
			Solution s=new Solution();
			boolean ans= s.search(arr,target);
			System.out.println("rst="+ans);		
		}
		}
}