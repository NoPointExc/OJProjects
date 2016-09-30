import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {                
        if(root == null || p == null){
            return null;
        }        
        TreeNode successor = null;
  
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        boolean pNext = false;
        while(node !=null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                if(pNext){
                    successor = node;
                    break;
                }
                pNext = (p == node); 
                node = node.right;
            }
        }
    
        return successor;
    }
}