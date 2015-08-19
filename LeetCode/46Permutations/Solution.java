import java.util.*;
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> list=new ArrayList<List<Integer>>();
    	if(nums.length==1){
    		List<Integer> tmp=new ArrayList<Integer>();
    		tmp.add(nums[0]);
    		list.add(tmp);
    		return list;
    	} 
    	for(int i=0;i<nums.length;i++){
    		int head=nums[i];
    		int[] pool=new int[nums.length-1];
    		int p=0;
    		for(int j=0;j<nums.length;j++)
    			if(i!=j) pool[p++]=nums[j];		
    		List<List<Integer>> tails=permute(pool);
    		int size=tails.size();   		
    		for(int j=0;j<size;j++){
    			List<Integer> sub=new ArrayList<Integer>();
    			sub.add(head);
    			sub.addAll(tails.get(j));
    			list.add(sub);
    		}   		
    	}
    	return list;
    }
}