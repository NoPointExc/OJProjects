
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int depth=0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            depth++;
            for(int i=0;i<levelSize;i++){
                TreeNode top=queue.poll();
                if(top.left!=null) queue.offer(top.left);
                if(top.right!=null) queue.offer(top.right);
            }
        }
        return depth;
    }
}