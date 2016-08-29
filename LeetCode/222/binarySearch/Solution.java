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
	public int countNodes(TreeNode root) {
		int depth = getDepth(root);
		boolean[] path;
		int r = (int)Math.pow(2,depth)-1; 
		int l = 0;
		int mid = (l+r)/2;
		
		TreeNode lastNode = root;
		
		while(mid>l){
			TreeNode p = root;
			path = getPath(mid,depth);
			for(boolean goRight:path){
				if(goRight)
					p=p.right;
				else
					p=p.left;
			}

			if(p.left==null){
				// all null, search in the left side
				r = mid;
				mid = (l+r)/2;
			}else if(p.right!=null){
				//left!=null && right!=null, go right half side
				l = mid+1;
				mid = (l+r)/2;
			}else{
				//found! left!=null, righ==null
				break;
			}
			lastNode = p;
		}
		
		int rst=0;
		for(int i=0;i<depth;i++){
			rst += (int)Math.pow(2,i);
		}
		
		if(lastNode!=null){
			if(lastNode.left==null){
				rst += mid*2;
			}else if(lastNode.right!=null){
				rst += (mid+1)*2;
			}else{
				rst += mid*2+1;
			}

		}

		return rst;
	}

	private int getDepth(TreeNode root){
		int depth = 0;
		while(root != null){
			depth++;
			root = root.right;
		}
		return depth;
	}

	private boolean[] getPath(int mid, int depth){
		boolean[] rst = new boolean[depth-1];
		for(int i=depth-2;i>=0;i--){
			rst[i] = mid%2==1;
			mid = mid/2;
		}
		return rst;
	}
}
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
	public int countNodes(TreeNode root) {
		int depth = getDepth(root);
		boolean[] path;
		int r = (int)Math.pow(2,depth)-1; 
		int l = 0;
		int mid = (l+r)/2;
		
		TreeNode lastNode = null;
		
		while(mid>l){
			TreeNode p = root;
			path = getPath(mid,depth);
			for(boolean goRight:path){
				if(goRight)
					p=p.right;
				else
					p=p.left;
			}

			if(p.left==null){
				// all null, search in the left side
				r = mid;
				mid = (l+r)/2;
			}else if(p.right!=null){
				//left!=null && right!=null, go right half side
				l = mid+1;
				mid = (l+r)/2;
			}else{
				//found! left!=null, righ==null
				break;
			}
			lastNode = p;
		}
		
		int rst=0;
		for(int i=0;i<depth;i++){
			rst += (int)Math.pow(2,i);
		}
		
		if(lastNode!=null){
			if(lastNode.left==null){
				rst += mid*2;
			}else if(lastNode.right!=null){
				rst += (mid+1)*2;
			}else{
				rst += mid*2+1;
			}

		}

		return rst;
	}

	private int getDepth(TreeNode root){
		int depth = 0;
		while(root != null){
			depth++;
			root = root.right;
		}
		return depth;
	}

	private boolean[] getPath(int mid, int depth){
		boolean[] rst = new boolean[depth-1];
		for(int i=depth-2;i>=0;i--){
			rst[i] = mid%2==1;
			mid = mid/2;
		}
		return rst;
	}
}
