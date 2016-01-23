
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len=postorder.length;
        if(len==0) return null;
        TreeNode root=new TreeNode(postorder[len-1]);
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        stack.push(root);
        int j=len-1;
        for(int i=len-2;i>=0;i--){
            TreeNode cur=stack.peek();
            if(cur.val!=inorder[j]){
                cur.right=new TreeNode(postorder[i]);
                stack.push(cur.right);
            }else{
                while(!stack.isEmpty()   && stack.peek().val==inorder[j]){
                    j--;
                    cur=stack.pop();
                }
                if(j>=0){
                    cur.left=new TreeNode(postorder[i]);
                    stack.push(cur.left);    
                }
            }
        }
        return root;
    }
}