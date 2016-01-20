import java.util.*;
public class Solution {
	LinkedList<List<Integer>> lst=new LinkedList<List<Integer>>();
   	Queue<TreeNode> queue=new LinkedList<TreeNode>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
    	if(root==null) return lst;
    	queue.add(root);  	  
    	while(!queue.isEmpty()){ 
    		int levelSize=queue.size();
    		int level=lst.size();
    		LinkedList<Integer> subLst=new LinkedList<Integer>();
    		for(int i=0;i<levelSize;i++){
    			if(queue.peek().left!=null) queue.offer(queue.peek().left);
    			if(queue.peek().right!=null) queue.offer(queue.peek().right);
    			if(level%2==1) subLst.addFirst(queue.poll().val);
    			else subLst.add(queue.poll().val);
    		}  		
    		if(subLst.size()!=0) lst.add(subLst);
    	} 	
    	return lst;        
    }    
}