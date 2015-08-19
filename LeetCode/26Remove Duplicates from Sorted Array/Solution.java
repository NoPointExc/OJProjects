import java.util.*;
public class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set=new HashSet<Integer>();
        int len=nums.length;
        int rm=0,i=0;
        //scan
        while(i<len){
        	nums[rm]=nums[i];
        	if(set.add(nums[i])){
        		rm++;i++;
        	}else{      	
        		i++;
      	 	}      	
        }
        return rm;
    }
}