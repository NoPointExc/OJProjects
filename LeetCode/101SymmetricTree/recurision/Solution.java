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
    public boolean isSymmetric(TreeNode root) {
        return root==null || equals(root.left,root.right);
    }
    private boolean equals(TreeNode t1,TreeNode t2){
    	if(t1==null || t2==null) return t1==null && t2==null;
    	return t1.val==t2.val && equals(t1.left,t2.right) && equals(t1.right,t2.left);
    }
}