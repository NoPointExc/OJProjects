import java.util.*;

public class Solution {
	private LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	pathSum(root,sum,new LinkedList<Integer>());
    	return list;
	}

    private void pathSum(TreeNode root, int sum,List<Integer> pth) {    	   	
    	if(root==null) return;
    	int val=root.val;    	
    	pth.add(val);	
    	if(root.left==null && root.right==null){
    		if(sum==val) list.add(pth);
    		return;
    	}
    	pathSum(root.left,sum-val,new LinkedList<Integer>(pth));
    	pathSum(root.right,sum-val,new LinkedList<Integer>(pth));
    }
    
}