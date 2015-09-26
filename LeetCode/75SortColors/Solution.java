public class Solution {
    public void sortColors(int[] nums) {
    	if(nums.length==0) return;
    	int h=0,p=0,t=nums.length-1;
    	while(p<=t&&h<=t){
    		if(nums[p]==0){
    			if(p==h){
    				p++;
    			}else{						
	    			nums[h]=nums[p]^nums[h];
	    			nums[p]=nums[p]^nums[h];
	    			nums[h]=nums[p]^nums[h];
    				h++;
    			}
    			
    		}else if(nums[p]==1){
    			p++;
    		}else{
    			if(p!=t){
    				nums[t]=nums[t]^nums[p];
    				nums[p]=nums[t]^nums[p];
    				nums[t]=nums[t]^nums[p];
    			}    			
    			t--;
    		}
    	}
    }
}