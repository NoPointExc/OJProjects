public class Solution {
	    public int singleNumber(int[] nums) {
			Arrays.sort(nums);
			int i=0;
			while(i+2<nums.length){
				if(nums[i]!=nums[i+1]) return nums[i];
				i+=3;
			}
			return nums[i];
		}
}