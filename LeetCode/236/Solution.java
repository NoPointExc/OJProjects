mport java.util.*;

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode pt = root;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> pAnc = null;
		LinkedList<TreeNode> qAnc = null;
		TreeNode lastVisited = null;

		while(pt!=null || !stack.isEmpty()){
			if(pt==null){
				if(stack.peek().right==null || stack.peek().right==lastVisited){
					lastVisited = stack.pop();
					if(lastVisited==p){
						pAnc = new LinkedList<TreeNode>(stack);
						pAnc.push(lastVisited);
					}

					if(lastVisited==q){
						qAnc = new LinkedList<TreeNode>(stack);
						qAnc.push(lastVisited);
					}

					if(pAnc!=null && qAnc!=null) break;
				}else{
					pt = stack.peek().right;
				}
			}else{
				stack.push(pt);
				pt = pt.left;
			}
		}

		if(pAnc==null || qAnc==null)
			return root;
		HashSet<TreeNode> dict = new HashSet<TreeNode>(pAnc);
		Iterator<TreeNode> it = qAnc.iterator();
		while(it.hasNext()){
			TreeNode i = it.next();
			if(dict.contains(i))
				return i;
		}

		return root;
	}
}

