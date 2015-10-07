public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int h=1;
        boolean dup=false;
        for(int i=1;i<nums.length;i++){
    		if(dup){
    			if(nums[i]==nums[i-1]) {

    			}else{
    				dup=false;
    				nums[h]=nums[i];
    				h++;
    			}
    		}else{
    			if(nums[i]==nums[i-1]) {
    				dup=true;
    				nums[h]=nums[i];
    				h++;
    			}else{
    				nums[h]=nums[i];
    				h++;
    			}
    		}
        	
        }
        //for(int i=0;i<nums.length;i++) System.out.print(nums[i]+",");
        return h;
    }
}