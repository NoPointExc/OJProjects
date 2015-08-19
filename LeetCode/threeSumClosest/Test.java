class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] nums={-1, 2, 1, -4};
		int target=1; 
		int ans=s.threeSumClosest(nums,target);
		System.out.println("ANS:"+ans);
	}
}