public class Solution {
    public int removeElement(int[] nums, int val) {
        int len=nums.length;
        int i=0,j=len;
        while(i<j){
        	if(nums[i]==val) {
        		j--;
        		int tmp=nums[j];
        		nums[j]=nums[i];
        		nums[i]=tmp;
        	}else{
        		i++;
        	}
        }
        return j;
    }
}