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
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> rst = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode pt = root;

		while(pt != null || !stack.isEmpty()){
			if(pt == null){
				pt = stack.pop();
			}else{
				rst.add(pt.val);
				if(pt.right != null)
					stack.push(pt.right);
				pt = pt.left;
			}
		}

		return rst;
	}
}
