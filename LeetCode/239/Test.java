class Test{
    public static void main(String[] args){
	Solution s =new Solution();
	int[] nums = {-7,-8,7,5,7,1,6,0};
	int k=4;	
	int[] rst = s.maxSlidingWindow(nums,k);
	for(int i:rst)
	    System.out.print(i);
    }
}
