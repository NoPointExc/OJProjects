public class Solution {
    public boolean isValidBST(TreeNode root) {
    	return isValid(root,(long)Integer.MAX_VALUE+100,(long)Integer.MIN_VALUE-100);
    }
    public boolean isValid(TreeNode root,long max,long min){
    	if(root==null) return true;
    	if(root.val>=max||root.val<=min) return false;
    	else return isValid(root.left,root.val,min) && isValid(root.right,max,root.val);
    }
}