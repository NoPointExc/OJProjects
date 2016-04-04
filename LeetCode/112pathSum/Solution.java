import java.util.*;
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode cur=root;
        int curSum=0;        
        while(!stack.isEmpty()){
            cur=stack.pop();
            //System.out.println(cur.val);
            if(cur.left==null && cur.right==null && cur.val==sum){
                return true;
            }
            if(cur.left!=null){
                cur.left.val+=cur.val;
                stack.push(cur.left);
            }
            if(cur.right!=null){
                cur.right.val+=cur.val;
                stack.push(cur.right);
            }    
        }
        return false;
    }
}