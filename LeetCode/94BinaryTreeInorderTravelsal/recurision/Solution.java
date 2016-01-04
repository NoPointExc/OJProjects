import java.util.*;
public class Solution {
    List<Integer> rst=new LinkedList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
       if(root!=null)  travel(root);
       return rst;
    }

    private void travel(TreeNode root){
       if(root.left!=null) inorderTraversal(root.left);
       if(root!=null) rst.add(root.val);
       if(root.right!=null) inorderTraversal(root.right);
    }
}