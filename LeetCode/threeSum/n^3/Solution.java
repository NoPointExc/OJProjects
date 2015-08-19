import java.util.*;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	//Map<Integer, List<Integer>> num=new HashMap<>();
    	int len=nums.length;
    	List<List<Integer>> ans=new ArrayList<List<Integer>>();
    	for(int i=0;i<len;i++){
    		for(int j=i+1;j<len;j++){
  				int k=-nums[i]-nums[j];
  				if(search(k,j,len,nums)){
  					List<Integer> tmp=new ArrayList();
  					tmp.add(nums[i]);
  					tmp.add(nums[j]);
  					tmp.add(k);
  					ans.add(tmp);
  					break;
  				}
    		}
    	}
    	return ans;

    }
    public boolean search(int k,int start,int end, int[] nums){
    	for(int i=start;i<end;i++){
    		if(nums[i]==k)return true;
    	}
    	return false;
    }
}