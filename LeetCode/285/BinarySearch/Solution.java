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
        TreeNode node = root;
        
        while(node != null){
            if(p.val < node.val){
                successor = node;
                node = node.left;
            }else{
                node = node.right;
            }
        }
                
        return successor;
    }
}