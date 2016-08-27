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
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rst = new LinkedList<Integer>();
		if(root==null) 
			return rst;
		ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
		curLevel.add(root);

		while(curLevel.size()!=0){
			TreeNode rightMost = curLevel.get(curLevel.size()-1);
			rst.add(rightMost.val);
			for(TreeNode node:curLevel){
				if(node.left!=null)
					nextLevel.add(node.left);
				if(node.right!=null)
					nextLevel.add(node.right);
			}
			curLevel = nextLevel;
			nextLevel = new ArrayList<TreeNode>();
		}

		return rst;
	}
}
