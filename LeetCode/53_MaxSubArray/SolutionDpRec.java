public class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums,0,nums.length);
    }

    private int maxSubArray(int[] nums, int h, int t){  	
    	while(h<t && nums[h]<=0) h++;
    	while(h<t && nums[t-1]<=0) t--;
    	print(nums,h,t);
    	if(h==t) return 0;
    	int sum=0;    	
    	for(int i=h;i<t;i++){
    		sum+=nums[i];
    	}
    	int lsum=maxSubArray(nums,h+1,t);
    	int rsum=maxSubArray(nums,h,t-1);
    	if(sum<lsum){
    		sum=lsum;
    	}
    	if(sum<rsum){
    		sum=rsum;
    	}
    	return sum;
    }

    private void print(int[] nums, int h,int t){
    	for(int i=h;i<t;i++) System.out.print(nums[i]+",");
    	System.out.println("");
    	System.out.println("-----------------------");
    }
}