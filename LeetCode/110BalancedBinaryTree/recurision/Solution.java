
public class Solution {
    
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftDep=depth(root.left);
        int rightDep=depth(root.right);
        return Math.abs(leftDep-rightDep)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int depth(TreeNode root){
        if(root==null) return 0;
        int leftDep=depth(root.left);
        int rightDep=depth(root.right);
        return Math.max(leftDep,rightDep) +1;
    }
}