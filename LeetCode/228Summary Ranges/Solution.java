import java.util.*;
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<String>();
        int h=0,t=0;
        if(nums.length==0) return ans;
        h=nums[0];
        t=nums[0];
        for(int i=1;i<nums.length;i++){
        	if(nums[i]==nums[i-1]+1) t=nums[i];
        	else{
        		StringBuilder sb=new StringBuilder();
        		sb.append(h);
        		if(h!=t){
        			sb.append("->");
        			sb.append(t);
        		}        	
        		ans.add(sb.toString());
        		h=nums[i];t=nums[i];
        	}
        }
        StringBuilder sb=new StringBuilder();
        		sb.append(h);
        		if(h!=t){
        			sb.append("->");
        			sb.append(t);
        		}        	
        		ans.add(sb.toString());
        return ans;
    }
}