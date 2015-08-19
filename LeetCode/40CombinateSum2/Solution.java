	import java.util.*;
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
 		List<List<Integer>> ans=new ArrayList<List<Integer>> ();
 		Arrays.sort(candidates);
 		getList(candidates,target,0,new ArrayList<Integer>(),ans,new HashSet<List<Integer>> ());
 		return ans;    
    }

    public void getList(int[] candidates, int target, int start,List<Integer> node,List<List<Integer>> ans, Set<List<Integer>> dict){
    	if(target==0) {
    		if(dict.add(node)){
    			ans.add(node);	
    		}
    		
    		return;
    	}
    	for(int i=start;i<candidates.length;i++){
    		int left=target- candidates[i];
    		if(left>=0){
    			List<Integer> copy=new ArrayList<Integer>(node); 
    			copy.add(candidates[i]);
    			getList(candidates,left,i+1,copy,ans,dict);
    		}else break;
    	}
    }
}