 import java.util.*;
 public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     	int len=nums.length;
     	List<List<Integer>> ans=new ArrayList<List<Integer>>();
     	//quick sort
    	nums=quickSort(nums,0,len);
     	for(int i=0;i<len;i++){
     		for(int j=i+1;j<len;j++){

     		}
     	}
     	//search 

     	return null;
    }


    //***********quick sort*************
    public int[] quickSort(int[] nums, int h,int t){
    	//System.out.println("h="+h+"  ,t="+t);
    	//print(nums); //{3,2,1}, h=0,t=3
    	int i=h+1; //i=1
    	for(int j=h+1;j<t;j++){ //j=1~2
    		if(nums[j]<nums[h]) {
    			switchEle(nums,j,i);
    			i++;
    		}   	
    	}
    	switchEle(nums,h,i-1);
    	if(i>h+1)  quickSort(nums,h,i);
    	if(t>i+1) return quickSort(nums,i,t);
     	return nums; //{3,9,7}, 0,3
    }

    private void switchEle(int[] nums, int i, int j){
    	if(i==j) return;
    	int tmp=nums[i];
    	nums[i]=nums[j];
    	nums[j]=tmp;
    }

    private void print(int[] nums){
    	for(int i=0;i<nums.length;i++){
    		System.out.print(nums[i]);
    	}
    	System.out.println();
    }
}
