import java.util.*;
public class Solution {
    public int firstMissingPositive(int[] nums) {
       Set<Integer> dict=new HashSet<Integer> ();
       int max=0;
       for(int i=0;i<nums.length;i++){
       		if(nums[i]>0) dict.add(nums[i]);
       		if(max<nums[i]) max=nums[i];
       }

       for(int i=1;i<max+1;i++){
       		if(dict.add(i)) return i;
       }
       return max+1;
    }
}