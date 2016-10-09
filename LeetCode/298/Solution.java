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
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        if(root != null){   
            dfs(root, 1);
        }
        return max;
    }
    
    private void dfs(TreeNode node, int len){
        max = Math.max(len, max);
        if(node.left != null){
            dfs(node.left, node.left.val == node.val + 1 ? len + 1 : 1);
        }
        
        if(node.right != null){
            dfs(node.right, node.right.val == node.val + 1 ? len + 1 : 1);
        }
    }
}