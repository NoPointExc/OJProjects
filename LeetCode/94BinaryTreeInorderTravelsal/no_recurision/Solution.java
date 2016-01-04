
/*
	[3,1,null,null,2]
	      3
      1      null
 null    2 
 */
import java.util.*;
public class Solution {
    
    List<Integer> rst=new LinkedList<Integer>();
    HashSet<TreeNode> marks=new HashSet<TreeNode>();

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> nodes=new Stack<TreeNode>();
        TreeNode p=root;
        while(p!=null){
        	if(p.left!=null && !marks.contains(p.left)){
        		nodes.push(p);
        		p=p.left;
        	}else{
        		if(!marks.contains(p)) visit(p);
        		if(p.right!=null && !marks.contains(p.right)){
        			nodes.push(p);
        			p=p.right;
        		}else if(!nodes.isEmpty()) p=nodes.pop();	
        		else p=null;
        	}
        }
        return rst;        
    }

    private void visit(TreeNode node){
    	marks.add(node);
    	rst.add(node.val);
    }
}