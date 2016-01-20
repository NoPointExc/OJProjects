import java.util.*;
public class Solution {
	List<List<Integer>> lst=new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        travel(root,0);
        return lst;
    }

    private void travel(TreeNode node,int level){    	
    	if(node==null) return;
    	addToList(node.val, level);
    	travel(node.left,level+1);
    	travel(node.right,level+1);
    }

    private void addToList(int val, int level){
    	List<Integer> levelList;
    	if(level+1>lst.size()){
    	 	levelList=new LinkedList<Integer>();
    	 	lst.add(levelList);	 	
    	}else levelList=lst.get(level);
    	levelList.add(val);   	
    }
}