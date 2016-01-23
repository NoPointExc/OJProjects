import java.util.*;
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	LinkedList<Integer> sub=new LinkedList<Integer>();            
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
            	TreeNode cur=queue.poll();
            	sub.add(cur.val);
            	if(cur.left!=null) queue.offer(cur.left);
            	if(cur.right!=null) queue.offer(cur.right);            	
            }
            if(sub.size()!=0) list.addFirst(sub);            
        }
        return list;
    }