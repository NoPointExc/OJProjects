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
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> rst = new LinkedList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode pt = root;
		TreeNode lastVisited=null;

		while(pt!=null || !stack.isEmpty()){
			if(pt==null){
				TreeNode peek = stack.peek();
				if(peek.right==null || peek.right==lastVisited){
					lastVisited=peek;
					rst.add(stack.pop().val);
				}else{
					pt=peek.right;
				}
			}else{
				stack.push(pt);
				pt = pt.left;
			}
		}

		return rst;
	}
}
