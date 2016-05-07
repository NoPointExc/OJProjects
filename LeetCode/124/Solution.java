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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
	maxChildPath(root);
	return max;
    }

    private int maxChildPath(TreeNode root){
	if(root==null) return 0;
   	//if(root.left==null&&root.right==null) return root.val;
	int lval=0;
	int rval=0;
   	if(root.right!=null){
		rval=maxChildPath(root.right);
	}
	if(root.left!=null){
		lval=maxChildPath(root.left);
	}
	int tmp=root.val;
	if(lval>0){
		tmp+=lval;
	}
	if(rval>0){
		tmp+=rval;
	}	
	max=max>tmp?max:tmp;

	int maxChild=lval>rval?lval:rval;
	return (maxChild>0?maxChild:0)+root.val;
   }
}	
