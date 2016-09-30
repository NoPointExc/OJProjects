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
    
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
             
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
                //visit left here
                if( node != null && node.left ==null && node.right ==null){
                    sum += node.val;
                }
            }else{
                node = stack.pop();
                node = node.right;
            }    
        }
        
        return sum;
    }
    
}