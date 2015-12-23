import java.util.*;
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> rst=new ArrayList<List<Integer>>();
        Set<List<Integer>> hash=new HashSet<List<Integer>>();
        int len=(int)Math.pow(2,nums.length);
        int[] bin=new int[len];
        for(int i=0;i<len;i++){
            int dec=i;
            List<Integer> ls=new ArrayList<Integer>();
            for(int j=0;j<nums.length;j++){
             //calculate bin
             if(dec%2==1) ls.add(nums[j]);
             dec/=2;
            }
            //add dis-duplicate list
            if(hash.add(ls)) rst.add(ls);
        }
        return rst;
    }
}