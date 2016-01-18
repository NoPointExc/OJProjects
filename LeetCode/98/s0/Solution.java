
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean l=root.left==null,r=root.right==null;
        if(!l) l=less(root.left,root.val);
        if(!r) r=more(root.right,root.val);
        return l&&r&&isValidBST(root.left) && isValidBST(root.right);
        
    }
    private boolean less(TreeNode node,int v){
    	if(node==null) return true;
    	if(node.val<v) return less(node.left,v)&&less(node.right,v);
    	else return false;
    }
    private boolean more(TreeNode node,int v){
    	if(node==null) return true;
    	//boolean l=root.left==null,r=root.right==null;
    	if(node.val>v) return more(node.left,v)&&more(node.right,v);
    	else return false;
    }	
}
