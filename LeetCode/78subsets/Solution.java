import java.util.*;
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    	Arrays.sort(nums);
    	Set<List<Integer>> set=new HashSet<List<Integer>>();
        List<List<Integer>> combs=new ArrayList<List<Integer>>();
        List<Integer> zero=new ArrayList<Integer>();
    	combs.add(zero);
        for(int i:nums){
        	List<List<Integer>> tmp=combs;
        	combs=new ArrayList<List<Integer>>(last);
        	for(List<Integer> sub:combs){	    		
	    		List<Integer> a=new ArrayList<>(sub);
	    		a.add(i);
	    		tmp.add(tmp);		
    		}
    		combs.addAll(tmp);
        }
        return combs;
    }
}