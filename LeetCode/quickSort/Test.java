class Test {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {6,5,-1,4,53,8,2,7,3,5,7,8,9,0,2,3,4};
		int[] ans = s.quickSort(nums, 0, nums.length);
		print(ans);
	}


	private static void print(int[] nums) {
		System.out.println("**ANS**");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+",");
		}
		System.out.println();
	}
}