
import java.util.*;
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        TreeNode l=root.left;
        TreeNode r=root.right;
        while(l!=null&&r!=null&&l.val==r.val){
        	if(l.left==null) l=l.right;
        	else{
        		TreeNode next=l.left;
        		while(next.right!=null && next.right!=l) next=next.right;
        		if(next.right==null){
        			next.right=l;
        			l=l.left;
        		}else{
        			l=l.right;
        			next.right=null;
        		}
        	}
        	if(r.right==null) r=r.left;
        	else{
        		TreeNode next=r.right;
        		while(next.left!=null && next.left!=r) next=next.left;
        		if(next.left==null){
        			next.left=r;
        			r=r.right;
        		}else{
        			r=r.left;
        			next.left=null;
        		}
        	}
        	

        }
        return l==null && r==null;
    }
}