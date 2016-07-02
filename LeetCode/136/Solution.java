public class Solution {
	    public int singleNumber(int[] nums) {
			Arrays.sort(nums);
			int i=0;
			while(i+1<nums.length){
				if(nums[i]!=nums[i+1]) return nums[i];
				i+=2;
			}
			return nums[i];
		}
}
