 import java.util.*;
 public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     	int len=nums.length, schPt=0; //search from this point
     	
     	List<List<Integer>> ans=new ArrayList<List<Integer>>();
     	if(len<3) return ans;
     	//quick sort
    	nums=quickSort(nums,0,len);

     	for(int i=0;i<len;i++){
     		for(int j=i+1;j<len;j++){
     			int cmp=-nums[i]-nums[j];
     			schPt=j+1;
     			int tmp=binarySearch(nums,schPt,len,cmp);
     			if(tmp!=-1) {
     				schPt=tmp;//next time, the cmp must larger than nums[schpt];
     				List<Integer> tmpLs=new ArrayList<Integer>();
     				tmpLs.add(nums[i]);
     				tmpLs.add(nums[j]);
     				tmpLs.add(nums[tmp]);
     				ans.add(tmpLs);
     			} 
     		}
     	}
     	//search 

     	return ans;
    }
    //***********binary search**********
    //reutrn -1 is Not Found
    public int binarySearch(int[] nums,int h,int t ,int k){
    	int mid=(h+t)/2;
    	//System.out.println("mid="+mid+" ,h="+h+" ,t="+t);
 		if(h<0||h==t||t==0) return -1;
 		if(k==nums[mid]) return mid;
    	else if(k<nums[mid]) return binarySearch(nums,h,mid,k);
    	else return binarySearch(nums, mid+1, t, k );
    }

    //***********quick sort*************
    private int[] quickSort(int[] nums, int h,int t){
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
}