public class Solution {
    public void moveZeroes(int[] nums) {
	int i = 0; //zero index
	int j = 0; //no-zero index

	while( j < nums.length && i < nums.length){
	    while(i<nums.length && nums[i] != 0){
		i++;
	    }
	    j = i;
	    while(j<nums.length && nums[j] == 0 ){
		j++;
	    }
	    if(i<nums.length && j<nums.length){
		
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	    }
	}
    }

    public static void main(String[] args){
	Solution s = new Solution();
	int[] nums = {0,1,0,3,12};
	s.moveZeroes(nums);
	for(int i:nums)
	    System.out.print(i);
	System.out.println();
    }
}

