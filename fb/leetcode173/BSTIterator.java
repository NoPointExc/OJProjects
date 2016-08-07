/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	TreeNode p;
    public BSTIterator(TreeNode root) {
        this.p=root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return p!=null;
    }

    /** @return the next smallest number */
    public int next() {
        int rst=0;
        while(p!=null){
        	if(p.left==null){
        		rst=p.val;
        		p=p.right;
        		break;
        	}else{
        		//goto the right most of p.left
        		TreeNode tmp=p.left;
        		while(tmp.right!=null && tmp.right!=p)
        			tmp=tmp.right;
        		if(tmp.right==null){
        			//add extra link
        			tmp.right=p;
        			p=p.left;
        		}else{
        			//cancel extra link
        			tmp.right=null;
        			rst=p.val;
        			p=p.right;
        			break;
        		}
        	}
        }
        return rst;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */