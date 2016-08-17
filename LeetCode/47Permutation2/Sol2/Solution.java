import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
       List<List<Integer>> list=new ArrayList<List<Integer>>();
       //Arrays.sort(nums);
       permute(list,nums,0);
       return list; 
    }

    private void permute(List<List<Integer>> list, int[] nums, int k){
        if(k==nums.length-1){
            List<Integer> l=new ArrayList<Integer>();
            for(int n:nums){
                l.add(n);
            }
            list.add(l);
        }else{
            HashSet<Integer> reached=new HashSet<Integer>();
            for(int i=k;i<nums.length;i++){
                if(!reached.contains(nums[i])){ 
                    reached.add(nums[i]);
                    swap(nums,k,i);
                    permute(list,nums,k+1);
                    swap(nums,k,i);
                } 
            }
        }
    }

    private void swap(int[] num,int i,int k){
        int tmp=num[i];
        num[i]=num[k];
        num[k]=tmp;
    }
        
}
