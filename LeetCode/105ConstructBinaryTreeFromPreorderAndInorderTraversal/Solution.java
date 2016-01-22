import java.util.*;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {       
    	TreeNode root;
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        if(preorder.length==0) return null;
        root=new TreeNode(preorder[0]);
        stack.push(root);

        for(int i=1,j=0;i<preorder.length;i++){
        	TreeNode cur=stack.peek();
        	if(cur.val!=inorder[j]){
        		cur.left=new TreeNode(preorder[i]);
        		stack.push(cur.left);
        	}else{       		
        		while(!stack.isEmpty()&& stack.peek().val==inorder[j]){
        			j++;
        			cur=stack.pop();
        		} 
        		if(j<inorder.length){
					cur.right=new TreeNode(preorder[i]);
        			stack.push(cur.right);        			
        		}      		
        	}
        }
        return root;
    }
}